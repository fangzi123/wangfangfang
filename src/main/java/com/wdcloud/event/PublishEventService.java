package com.wdcloud.event;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author wangff
 * @date 2020/1/15 16:10
 */
@Slf4j
@Service
public class PublishEventService {
    @Autowired
    ApplicationContext applicationContext;

    public void publishEvent(UserBean userBean){
        applicationContext.publishEvent(new UserRegisterEvent(this,userBean));
    }

}
