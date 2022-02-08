package com.zhy.framework.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import com.zhy.framework.rabbitmq.config.RabbitMQConfig;
import com.zhy.hr.userinfo.domain.UserInfo;
import com.zhy.hr.userinfo.service.IUserInfoService;
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
import java.util.Date;

/**
 * @author zhouhongyin
 * @since 2022/2/8 21:00
 */
@Component
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

            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg);

            helper.setTo(userInfo.getSysUser().getEmail());
            helper.setFrom(mailProperties.getUsername());
            helper.setSubject("入职欢迎");
            helper.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("name", userInfo.getUserInfoName());
            context.setVariable("posName", userInfo.getSysDept().getDeptName());
            context.setVariable("joblevelName", userInfo.getJobLevel().getName());
            context.setVariable("departmentName",userInfo.getSysDept().getDeptName());
            String mail = templateEngine.process("mail", context);
            helper.setText(mail, true);
            javaMailSender.send(msg);
        } catch (Exception e) {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        }

    }

}
