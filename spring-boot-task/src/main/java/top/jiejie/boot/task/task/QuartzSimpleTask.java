package top.jiejie.boot.task.task;


/**
 * @program: spring-boot-learning
 * @description:
 * @author: ytq
 * @create: 2024-05-06 21:18
 **/
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import top.jiejie.boot.task.entity.User;
import top.jiejie.boot.task.service.UserService;
import top.jiejie.boot.task.utils.ExcelUtil;


import java.io.File;
import java.time.LocalDateTime;
import java.util.List;


@Component
@Slf4j
public class QuartzSimpleTask extends QuartzJobBean {

    @Resource
    private UserService userService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String fileName = System.getProperty("user.home") + File.separator + "user_data_" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        System.out.println("Quartz简单定时任务执行时间：" + LocalDateTime.now());
        List<User> users = userService.list();

        try {
            // 调用工具类方法，写数据到Excel
            ExcelUtil.writeExcel(fileName, users);
            System.out.println("Excel文件生成成功：" + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成Excel文件过程中发生错误.");
        }
    }
}