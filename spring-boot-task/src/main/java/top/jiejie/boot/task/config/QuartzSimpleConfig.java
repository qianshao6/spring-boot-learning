package top.jiejie.boot.task.config;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: ytq
 * @create: 2024-05-06 21:19
 **/

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.jiejie.boot.task.task.QuartzSimpleTask;

@Configuration
public class QuartzSimpleConfig {
    //指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(QuartzSimpleTask.class)
                .withIdentity("QuartzSimpleTask")
                .storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        //这里设定触发执行的方式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/20 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("QuartzSimpleTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}