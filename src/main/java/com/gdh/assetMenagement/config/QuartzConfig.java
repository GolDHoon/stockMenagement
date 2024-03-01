package com.gdh.assetMenagement.config;

import com.gdh.assetMenagement.schedule.KisReCertificationJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail kisReCertificationJobDetail() {
        return JobBuilder.newJob(KisReCertificationJob.class)
                .withIdentity("Kis재인증")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger kisReCertificationJobTrigger(JobDetail kisReCertificationJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(kisReCertificationJobDetail)
                .withIdentity("Kis재인증")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 * * * ?"))
                .build();
    }
}