package io.sohan.Springbatchdemo.config;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MyCustomWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String s:list){
            System.out.println("MyCustomWriter    : Writing data    : " + s);
        }
        System.out.println("MyCustomWriter    : Writing data    : completed");
    }
}
