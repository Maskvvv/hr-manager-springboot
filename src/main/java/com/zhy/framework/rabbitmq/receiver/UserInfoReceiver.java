package com.zhy.framework.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import com.zhy.framework.rabbitmq.config.RabbitMQConfig;
import com.zhy.hr.userinfo.domain.UserInfo;
import com.zhy.hr.userinfo.service.IUserInfoService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhouhongyin
 * @since 2022/2/8 21:00
 */
@Component
public class UserInfoReceiver {

    @Resource
    private IUserInfoService userInfoService;

    @RabbitListener(queues = RabbitMQConfig.SENDMAIL_CREAT_USERINFO_KEY)
    public void sendMailCreatUserinfo(Message message, Channel channel) {

        UserInfo userInfo = userInfoService.selectUserInfoByUserInfoId(Long.parseLong(new String(message.getBody())));



    }

}
