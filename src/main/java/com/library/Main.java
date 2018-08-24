package com.library;

import com.library.service.DemoService;
import com.library.service.Impl.DemoServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        DemoService demoService = applicationContext.getBean(DemoServiceImpl.class);

        demoService.startDemo();

        applicationContext.close();
    }
}
