package io.sohan.Springbatchdemo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
@Configuration
public class BatchJobListener extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(BatchJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        JobParameters params = jobExecution.getJobParameters();
        log.info("Files batch job started by {}", params.getString("BY_USER"));
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Files batch job completed at {}", LocalDateTime.now());
        }
    }
}