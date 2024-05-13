package top.jiejie.boot.task.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface Job {
    void execute(JobExecutionContext context)
            throws JobExecutionException;
}