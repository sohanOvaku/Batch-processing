package io.sohan.Springbatchdemo.config;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCustomProcessor implements ItemProcessor<String,String> {
    private String test;

    @Override
    public String process(String s) throws Exception {
//        System.out.println("MyCustomProcessor : Processing data : "+s);
        s=s.toUpperCase();
        return s;
    }
}
