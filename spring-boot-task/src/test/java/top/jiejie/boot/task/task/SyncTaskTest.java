package top.jiejie.boot.task.task;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @Author HHJ
 * @Date: 2024/05/06/ 下午2:58
 * @description
 */
@SpringBootTest
class SyncTaskTest {
    @Resource
    private SyncTask syncTask;

    @Test
    void testSyncTask() throws Exception {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
}