package com.wdcloud.mapper;

import com.wdcloud.config.SlaveDataSource;
import com.wdcloud.model.WdUser;
import tk.mybatis.mapper.common.Mapper;
@SlaveDataSource
public interface WdUserMapper extends Mapper<WdUser> {
}