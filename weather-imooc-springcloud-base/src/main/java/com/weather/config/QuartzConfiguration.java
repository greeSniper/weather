package com.weather.config;

import com.weather.job.WeatherDataSyncJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 唐哲
 * 2018-02-24 14:51
 */
//@Configuration
public class QuartzConfiguration {

    //半小时更新一次，刚好是redis中数据过期的时间
    private static final int TIME = 2; // 更新频率

    // JobDetail
//    @Bean
//    public JobDetail weatherDataSyncJobDetail() {
//        return JobBuilder
//                .newJob(WeatherDataSyncJob.class)
//                .withIdentity("weatherDataSyncJob")
//                .storeDurably()
//                .build();
//    }
//
//    // Trigger
//    @Bean
//    public Trigger weatherDataSyncTrigger() {
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
//                .simpleSchedule()
//                .withIntervalInSeconds(TIME)
//                .repeatForever();
//
//        return TriggerBuilder
//                .newTrigger()
//                .forJob(weatherDataSyncJobDetail())
//                .withIdentity("weatherDataSyncTrigger")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
//
//    @Bean
//    public Scheduler weatherDataSyncScheduler() throws SchedulerException {
//        SchedulerFactory sf = new StdSchedulerFactory();
//        Scheduler scheduler = sf.getScheduler();
//        scheduler.start();
//        scheduler.scheduleJob(weatherDataSyncJobDetail(), weatherDataSyncTrigger());
//        return scheduler;
//    }

//    public static void main(String[] args) throws SchedulerException {
//        JobDetail weatherDataSyncJobDetail = JobBuilder
//                .newJob(WeatherDataSyncJob.class)
//                .withIdentity("weatherDataSyncJob")
//                .storeDurably()
//                .build();
//
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
//                .simpleSchedule()
//                .withIntervalInSeconds(TIME)
//                .repeatForever();
//        Trigger weatherDataSyncTrigger = TriggerBuilder
//                .newTrigger()
//                .forJob(weatherDataSyncJobDetail)
//                .withIdentity("weatherDataSyncTrigger")
//                .withSchedule(scheduleBuilder)
//                .build();
//
//        //创建Scheduler实例
//        SchedulerFactory sf = new StdSchedulerFactory();
//        Scheduler scheduler = sf.getScheduler();
//        scheduler.start();
//        //将jobDetail与trigger传入scheduler中
//        scheduler.scheduleJob(weatherDataSyncJobDetail, weatherDataSyncTrigger);
//    }

}
