package com.wdcloud.mapper;

import com.wdcloud.config.datasource.MasterDataSource;
import com.wdcloud.model.OrgEmail;
import tk.mybatis.mapper.common.Mapper;
@MasterDataSource
public interface OrgEmailMapper extends Mapper<OrgEmail> {
}