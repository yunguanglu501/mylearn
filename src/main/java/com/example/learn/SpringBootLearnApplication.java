package com.example.learn;

import com.example.learn.chat.SimpleWebsocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.learn.mapper"})
@EnableScheduling
@EnableAsync
public class SpringBootLearnApplication {

    public static void main(String[] args) {
        // SimpleWebsocketServer simpleWebsocketServer = new SimpleWebsocketServer();
        // simpleWebsocketServer.start();
        SpringApplication.run(SpringBootLearnApplication.class, args);
    }

}
