package com.zhy;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.zhy.framework.rabbitmq.config.RabbitMQConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class HrManagerApplicationTests {

    @Autowired
    MailProperties mailProperties;

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void generateUsername() {

        String username = "zhy";

        String[] zhies = username.split("zhy1");
        System.out.println(zhies.length);
        for (String zhy : zhies) {
            System.out.println(zhy);
        }

        String username1 = "zhy12";

        String[] zhies1 = username1.split("zhy");
        System.out.println(zhies1.length);

        for (String s : zhies1) {
            System.out.println(s);
        }
    }

    @Test
    void sendMail() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);

        helper.setTo("2668989410@qq.com");
        helper.setFrom(mailProperties.getUsername());
        helper.setSubject("入职欢迎");
        helper.setSentDate(new Date());
        Context context = new Context();
        context.setVariable("name", "张三");
        context.setVariable("posName", "研发部");
        context.setVariable("joblevelName", "普通员工");
        context.setVariable("departmentName", "研发部");
        String mail = templateEngine.process("mail", context);
        helper.setText(mail, true);
        javaMailSender.send(msg);

    }

    @Test
    void rabbitMQ() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, RabbitMQConfig.SENDMAIL_CREAT_USERINFO_KEY, "8");
    }

    @Test
    void dateTest() {
        Date date = new Date(1532058425000L);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date(1532058425000L));
        System.out.println(date);
        System.out.println(System.currentTimeMillis());
    }

    @Test
    void uuidTest() {

        System.out.println(UUID.randomUUID().toString());
        System.out.println(IdUtil.simpleUUID());
    }


}
