package io.sohan.Springbatchdemo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BatchJobLauncher {
    private static final Logger log = LoggerFactory.getLogger(BatchJobLauncher.class);

        @Autowired
        private JobLauncher jobLauncher;

        @Autowired
        private Job job;

        public void startJob(List<String> list) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//            Map<String, JobParameter> paramsMap = new HashMap<>();
//            paramsMap.put("TIME", new JobParameter(new Date()));
//            paramsMap.put("BY_USER", new JobParameter("John Doe"));
//            paramsMap.put("Test",new JobParameter("Sohan"));

//            JobParameters params = new JobParameters(paramsMap);
//            System.out.println(list);
            Map<String, JobParameter> paramStr = new HashMap<>();
            paramStr.put("DATA", new OvakuJobParameter("Sohan"));
            JobParameters params1 = new JobParameters(paramStr);

            JobExecution jobExecution = jobLauncher.run(job, params1);

            log.info("Job execution status {}", jobExecution.getStatus());
        }

}
