package com.wdcloud.event;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wangff
 * @date 2020/1/15 16:23
 */
@Slf4j
@Component
public class AnnotationListener {

    @Async
    @EventListener
    public void eventListener(UserRegisterEvent event){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("AnnotationListener================>{}", JSON.toJSONString(event.getUserBean()));
        log.info("AnnotationListener================>{}", JSON.toJSONString(event.getSource().getClass()));
    }
}
