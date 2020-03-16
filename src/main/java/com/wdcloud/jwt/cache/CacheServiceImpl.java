package com.wdcloud.jwt.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Service
public class CacheServiceImpl implements CacheService {

    private Cache<String,Object> commonCache=null;


    @PostConstruct
    public void init(){
        commonCache= CacheBuilder.newBuilder()
                //缓存初始容量10
                .initialCapacity(10)
                //最多100个key，超过按LRU策略移除
                .maximumSize(1000)
                //写入后多少时间过期
                .expireAfterWrite(2, TimeUnit.HOURS).build();
    }
    @Override
    public void setCommonCache(String key, Object value) {
        commonCache.put(key,value);
    }

    @Override
    public Object getFromCommonCache(String key) {
        return commonCache.getIfPresent(key);
    }

}