package top.jiejie.boot.task.job;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.jiejie.boot.task.service.MailService;

import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: HHJ
 * @create: 2024-05-06 15:42
 **/
@Component
@Slf4j
public class ScheduledJobs {
    private final MailService mailService;

    public ScheduledJobs(MailService mailService) {
        this.mailService = mailService;
    }

    //@Scheduled(fixedDelay = 3000)
    //public void fixedDelay() throws InterruptedException {
    //    log.info("fixedDelay start:{}", new Date());
    //    sleep(5000);
    //    log.info("fixedDelay end:{}", new Date());
    //}
    //
    //@Scheduled(fixedRate = 4000)
    //public void fixedRateJob() {
    //    log.info("fixedRateJob start:{}", new Date());
    //    log.info("fixedRateJob end:{}", new Date());
    //}

    //@Scheduled(cron = "0/60 9 16 6 5 ? ")
    //public void cronJob() {
    //    log.info("cronJob start:{}", new Date());
    //    log.info("生日快乐");
    //}

//    @Scheduled(cron = "0/60 04 22 6 5 ? ")
//    public void happyCronJob() throws MessagingException {
//        String content = """
//                <head>
//                           <title>天天开心</title>
//
//                """;
//        mailService.sendHtmlMail("16422802@qq.com","天天开心",content);
//        log.info("邮件发送成功");
//    }
}
