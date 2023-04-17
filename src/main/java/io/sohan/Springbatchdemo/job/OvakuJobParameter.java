package io.sohan.Springbatchdemo.job;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OvakuJobParameter extends JobParameter {
//    List<String> multipartFiles;
//    public OvakuJobParameter(List<String> multipartFiles){
//        super(UUID.randomUUID().toString());
//        this.multipartFiles = multipartFiles;
//    }
//
//    public List<String> getMultipartFiles() {
//        return multipartFiles;
//    }
    String name;
    public OvakuJobParameter(String name){
        super(UUID.randomUUID().toString());
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
