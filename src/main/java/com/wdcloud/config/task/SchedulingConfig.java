package com.wdcloud.config.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

@Slf4j
@Configuration
public class SchedulingConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setTaskScheduler(taskScheduler());

        /**
         * 动态修改定时规则
         * 触发运行的时候，刷新定时规则
         */
        TriggerTask triggrtTask = new TriggerTask(
                //1.添加任务内容(Runnable)
                () -> {System.out.println("执行定时任务: " + new Date());},
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1从数据库获取执行周期
                    String cron = "*/10 * * * * ?";
                    //2.2 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                });
        scheduledTaskRegistrar.addTriggerTask(triggrtTask);
    }

    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(4);
        scheduler.setThreadNamePrefix("task-pool-");
        scheduler.setAwaitTerminationSeconds(60*10);
        scheduler.setErrorHandler(throwable -> log.info("调度任务发生异常", throwable));
        scheduler.setWaitForTasksToCompleteOnShutdown(false);
        return scheduler;
    }

}
