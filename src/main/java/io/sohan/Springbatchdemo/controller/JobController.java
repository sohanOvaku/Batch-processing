package io.sohan.Springbatchdemo.controller;

import io.sohan.Springbatchdemo.job.BatchJobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class JobController {

    BatchJobLauncher batchJobLauncher;

    public JobController(BatchJobLauncher batchJobLauncher) {
        this.batchJobLauncher = batchJobLauncher;
    }

    @GetMapping("test")
    public String test(){
        List<String> list= new ArrayList<>(Arrays.asList("Zero", "One", "Two", "Three", "Four", "Five"));
        try{
            batchJobLauncher.startJob(list);
            return "Success";
        }catch (Exception e){
            return "test failed";
        }
    }
}
