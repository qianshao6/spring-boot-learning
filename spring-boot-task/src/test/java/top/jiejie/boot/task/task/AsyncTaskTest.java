package top.jiejie.boot.task.task;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsyncTaskTest {
    @Resource
    private AsyncTask asyncTask;
    @Test
    void testAsyncTask()throws Exception{
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }
}
