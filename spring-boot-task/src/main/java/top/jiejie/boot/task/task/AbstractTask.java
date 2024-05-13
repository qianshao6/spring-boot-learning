package top.jiejie.boot.task.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
 * @Author yun
 * @Date: 2024/05/06/ 下午2:53
 * @description
 */
@Slf4j
@Component
public abstract class AbstractTask {
    public void doTaskOne() throws Exception {
        log.info("doTaskOne");
        long startTime = currentTimeMillis();
        sleep(3000);
        long endTime = currentTimeMillis();
        log.info("完成任务一，耗时:{}毫秒", endTime - startTime);
    }

    public void doTaskTwo() throws Exception {
        log.info("doTaskTwo");
        long startTime = currentTimeMillis();
        sleep(4000);
        long endTime = currentTimeMillis();
        log.info("完成任务二，耗时:{}毫秒", endTime - startTime);
    }

    public void doTaskThree() throws Exception {
        log.info("doTaskThree");
        long startTime = currentTimeMillis();
        sleep(5000);
        long endTime = currentTimeMillis();
        log.info("完成任务三，耗时:{}毫秒", endTime - startTime);
    }
}