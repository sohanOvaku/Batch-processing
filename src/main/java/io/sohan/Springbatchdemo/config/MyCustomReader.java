package io.sohan.Springbatchdemo.config;

import io.sohan.Springbatchdemo.job.OvakuJobParameter;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

@Configuration
@StepScope
public class MyCustomReader implements ItemReader<String> {

    private String[] strArray={"Zero", "One", "Two", "Three", "Four", "Five"};

    @Value("#{jobParameters['DATA']}")
    private OvakuJobParameter list;

//    @Value("#{jobParameters['Test']}")
//    private String test;

    private int indx=0;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(indx > strArray.length || indx==5 ){
            return null;
        }
        String data=indx + " " + strArray[indx];//+ "by "+test;

//        try{
//        FileInputStream fileInputStream = new FileInputStream(list.getName());
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        ObjectInputStream in = new ObjectInputStream(bufferedInputStream);
////        Object object = objectInputStream.readObject();
////        objectInputStream.close();
//            OvakuJobParameter ovakuJobParameter=(OvakuJobParameter) in.readObject();

//        }

        System.out.println(list.getValue());
        System.out.println(list.getName());
//        test.remove(indx);
        indx++;
        return data;
    }


}
