package com.wdcloud.event;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wangff
 * @date 2020/1/15 16:20
 */
@Slf4j
@Component
public class UserBeanListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    @Async
    public void onApplicationEvent(UserRegisterEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("ApplicationListener================>{}", JSON.toJSONString(event.getUserBean()));
        log.info("ApplicationListener================>{}", JSON.toJSONString(event.getSource().getClass()));
    }
}
