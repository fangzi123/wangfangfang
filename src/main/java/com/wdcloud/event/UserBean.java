package com.wdcloud.event;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangff
 * @date 2020/1/15 15:50
 */
@Data
@Builder
public class UserBean {
    private String name;
    private String pwd;
}
