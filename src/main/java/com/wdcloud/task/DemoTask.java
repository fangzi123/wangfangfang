package com.wdcloud.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangff
 * @date 2020/1/9 14:34
 */
@Slf4j
@Component
public class DemoTask {
    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {
        log.info("【DemoTask】开始时间:{}",System.currentTimeMillis());
        log.info("【DemoTask】结束时间:{}",System.currentTimeMillis());
    }
}
