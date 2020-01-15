package com.wdcloud.event;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wangff
 * @date 2020/1/15 16:34
 */
@Slf4j
@Component
public class SmartDbListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass==UserRegisterEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType==PublishEventService.class;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Async
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserRegisterEvent event = (UserRegisterEvent) applicationEvent;
        log.info("SmartListener======入库==========>{}", JSON.toJSONString(event.getUserBean()));
    }
}
