package com.zhy.framework.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouhongyin
 * @since 2022/2/8 20:33
 */
@Configuration
public class RabbitMQConfig {
    public static final String TOPIC_EXCHANGE = "hrTopicExchange";

    public static final String SENDMAIL_CREAT_USERINFO_QUEUE = "sendMailCreatUserInfoQueue";
    public static final String SENDMAIL_CREAT_USERINFO_KEY = "sendMail.creat.userInfo";


    /**
     * 创建topic交换机
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE, true, false);
    }

    /**
     * 创建发送入职信息队列
     */
    @Bean
    public Queue sendMailCreatUserInfoQueue() {
        return new Queue(SENDMAIL_CREAT_USERINFO_QUEUE, true, false, false);
    }

    /**
     * 绑定交换机和队列
     */
    @Bean
    public Binding sendMailCreatUserInfoBinding() {
        return BindingBuilder.bind(sendMailCreatUserInfoQueue()).to(topicExchange()).with(SENDMAIL_CREAT_USERINFO_KEY);
    }


}
