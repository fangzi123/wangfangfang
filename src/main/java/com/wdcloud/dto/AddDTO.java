package com.wdcloud.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wangff
 * @date 2020/2/17 14:42
 */
@Data
public class AddDTO {
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
}
