package ru.ncallie.ToDo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class NotificationConfig {



//    @Async
//    @Scheduled(fixedRate = 1000)
//    public void scheduleTaskUsingCronExpression() {

//         long now = System.currentTimeMillis() / 1000;
//        System.out.println(
//                "schedule tasks using cron jobs - " + now);
//    }
}
