package com.zhy;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.mail.MailUtil;
import com.zhy.common.core.domain.entity.SysUser;
import com.zhy.framework.rabbitmq.config.RabbitMQConfig;
import com.zhy.hr.userinfo.domain.UserInfo;
import com.zhy.hr.userinfo.service.impl.UserInfoServiceImpl;
import com.zhy.system.mapper.SysUserMapper;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private UserInfoServiceImpl infoService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    void generateUsername() {

        String username = "zhy";

        String[] names = new String[]{"zhy", "zhy1", "zhy2", "zhy4"};

        int i = 0;
        int j = names.length - 1;

        while (i <= j) {
            int middle = (j + i) / 2;
            String[] nameArray = names[middle].split("zhy");
            int namesMiddle = nameArray.length > 0 ? Integer.parseInt(nameArray[1]) : 0;

            if (namesMiddle == middle) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }

        System.out.println(i);

        //for (String name : names) {
        //    System.out.println(Arrays.toString(name.split("zhy")));
        //    System.out.println(name.split("zhy").length);
        //}
    }
    @Test
    void generateUsername1() {
        System.out.println(infoService.generateUsername(UserInfo.builder().userInfoName("周宏寅").build()));
        //String[] names = sysUserMapper.selectUserList(SysUser.builder().userName("zhouhongyin").build()).stream().map(SysUser::getUserName).toArray(String[]::new);
        //
        //List<String> zhouhongyin = sysUserMapper.selectUserList(SysUser.builder().userName("zhouhongyin").build()).stream().map(SysUser::getUserName).collect(Collectors.toList());
        //zhouhongyin.forEach(System.out::println);
        //System.out.println("-------------------------");
        //Arrays.stream(names).forEach(System.out::println);

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
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, RabbitMQConfig.SENDMAIL_CREAT_USERINFO_KEY, "12");
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

    @Test
    void mailTest() {
        Context context = new Context();
        context.setVariable("userInfoName", "userInfo.getUserInfoName()");
        context.setVariable("userName", "userInfo.getSysUser().getUserName()");
        context.setVariable("dept", "userInfo.getSysDept().getDeptName()");
        context.setVariable("leader", "userInfo.getSysDept().getLeader()");
        context.setVariable("basicSalary", "userInfo.getSalary().getBasicSalary()");
        context.setVariable("bonus", "userInfo.getSalary().getBonus()");
        context.setVariable("lunchSalary", "userInfo.getSalary().getLunchSalary()");
        context.setVariable("trafficSalary", "userInfo.getSalary().getTrafficSalary()");

        String mail1 = templateEngine.process("mail1", context);

        MailUtil.send("2668989410@qq.com", "入职邀请", mail1, true);

    }


}
