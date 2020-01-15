package com.wdcloud.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author wangff
 * @date 2020/1/15 15:48
 */
@Getter
public class UserRegisterEvent extends ApplicationEvent {

    private UserBean userBean;

    public UserRegisterEvent(Object source,UserBean userBean) {
        super(source);
        this.userBean = userBean;
    }
}
