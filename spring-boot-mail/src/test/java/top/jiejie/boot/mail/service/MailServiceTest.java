package top.jiejie.boot.mail.service;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("1340037298@qq.com","jby","jby");
    }
    @Test
    void sendHtmlMail() throws MessagingException {
        String content = """
            <body>
            <h2>jby</h2>
            <img src="https://hhj-oss.oss-cn-hangzhou.aliyuncs.com/images/b8ef1b79-3810-4906-876a-c57bb55f5a8d.jpg"/>
            <a href="http://www.baidu.com" >百度</a>
            </body>
            """;
        mailService.sendHtmlMail("1340037298@qq.com","html",content);
    }
    @Test
    void sendAttachmentsMail() throws MessagingException {
        String filePath = "C:\\Users\\13400\\Desktop\\H\\1.png";
        mailService.sendAttachmentsMail("1340037298@qq.com","jby","jbysh",filePath);
    }
}