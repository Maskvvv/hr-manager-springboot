package com.zhy.framework.rabbitmq.receiver;

import cn.hutool.extra.mail.MailUtil;
import com.rabbitmq.client.Channel;
import com.zhy.common.annotation.Log;
import com.zhy.framework.rabbitmq.config.RabbitMQConfig;
import com.zhy.hr.userinfo.domain.UserInfo;
import com.zhy.hr.userinfo.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhouhongyin
 * @since 2022/2/8 21:00
 */
@Component
@Slf4j
public class UserInfoReceiver {

    @Resource
    private IUserInfoService userInfoService;

    @Autowired
    MailProperties mailProperties;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    JavaMailSender javaMailSender;

    @RabbitListener(queues = RabbitMQConfig.SENDMAIL_CREAT_USERINFO_QUEUE)
    public void sendMailCreatUserinfo(Message message, Channel channel) throws MessagingException, IOException {

        try {
            long userId = Long.parseLong(new String(message.getBody()));
            UserInfo userInfo = userInfoService.selectUserInfoByUserInfoId(userId);
            //log.info("邮件发送的用户：" + userInfo.toString());

            DateFormat dateFormat = new SimpleDateFormat("yy 年 MM 月 dd");
            DateFormat yy = new SimpleDateFormat("yyyy");
            DateFormat mm = new SimpleDateFormat("MM");
            DateFormat dd = new SimpleDateFormat("dd");
            Context context = new Context();
            context.setVariable("userInfoName", userInfo.getUserInfoName());
            context.setVariable("userName", userInfo.getSysUser().getUserName());
            context.setVariable("dept", userInfo.getSysDept().getDeptName());
            context.setVariable("leader", userInfo.getSysDept().getLeader());
            context.setVariable("basicSalary", userInfo.getSalary().getBasicSalary());
            context.setVariable("bonus", userInfo.getSalary().getBonus());
            context.setVariable("lunchSalary", userInfo.getSalary().getLunchSalary());
            context.setVariable("trafficSalary", userInfo.getSalary().getTrafficSalary());
            context.setVariable("beginDate", dateFormat.format(userInfo.getBeginDate()));
            context.setVariable("yy", yy.format(userInfo.getBeginDate()));
            context.setVariable("mm", mm.format(userInfo.getBeginDate()));
            context.setVariable("dd", dd.format(userInfo.getBeginDate()));

            String mail = templateEngine.process("mail1", context);
            //log.info("邮件内容：" + mail);

            MailUtil.send(userInfo.getSysUser().getEmail(), "未来科技有限公司入职邀请", mail, true);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (Exception e) {
            log.error("邮件发送失败", e);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        }

    }

    @RabbitListener(queues = RabbitMQConfig.SENDMAIL_CREAT_USERINFO_QUEUE_TEST)
    public void sendtest(Message message, Channel channel) throws MessagingException, IOException {
        System.out.println(new String(message.getBody()));

    }


}
