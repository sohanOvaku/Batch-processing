package io.sohan.Springbatchdemo.job;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public class OvakuJobParameters extends JobParameters {
    private Map<String, List<String>> parameters;

    public OvakuJobParameters(Map<String, List<String>> parameters) {
        this.parameters = parameters;
    }

}
