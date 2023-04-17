package io.sohan.Springbatchdemo.config;

import io.sohan.Springbatchdemo.job.BatchJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private BatchJobListener batchJobListener;
    @Autowired
    private MyCustomReader myCustomReader;
    @Autowired
    private MyCustomWriter myCustomWriter;
    @Autowired
    private MyCustomProcessor myCustomProcessor;

//    public BatchCofig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, BatchJobListener batchJobListener) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//        this.batchJobListener = batchJobListener;
//    }

    @Bean
    public Job createJob(){
        return jobBuilderFactory.get("Job1")
                .incrementer(new RunIdIncrementer()).listener(batchJobListener)
                .flow(createStep())
                .end().build();
    }

    @Bean
    public Step createStep(){
        return stepBuilderFactory.get("Step1")
                .<String,String> chunk(1)
                .reader(myCustomReader)
                .processor(myCustomProcessor)
                .writer(myCustomWriter)
                .build();
    }
}
