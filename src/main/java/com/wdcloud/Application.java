package com.wdcloud;

import com.wangff.TestConfig;
import com.wangff.TestImportBeanDefinitionRegistrar;
import com.wangff.TestImportSelector;
import com.wdcloud.model.WdUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Import({WdUser.class, TestConfig.class, TestImportSelector.class,
        TestImportBeanDefinitionRegistrar.class
})
@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan("com.wdcloud.mapper")
public class Application{

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(Application.class, args);
        context.getBean("org.springframework.scheduling.annotation.ProxyAsyncConfiguration");
        context.getBean("org.springframework.context.annotation.internalAsyncAnnotationProcessor");
    }

    @Primary
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);//核心线程数，默认为1
        executor.setMaxPoolSize(8);//最大线程数，默认为Integer.MAX_VALUE
        executor.setQueueCapacity(10000);//队列最大长度，一般需要设置值>=notifyScheduledMainExecutor.maxNum；默认为Integer.MAX_VALUE
        executor.setKeepAliveSeconds(60);//线程池维护线程所允许的空闲时间，默认为60s
        /* <!-- AbortPolicy:直接抛出java.util.concurrent.RejectedExecutionException异常 -->
            <!-- CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度 -->
            <!-- DiscardOldestPolicy:抛弃旧的任务、暂不支持；会导致被丢弃的任务无法再次被执行 -->
            <!-- DiscardPolicy:抛弃当前任务、暂不支持；会导致被丢弃的任务无法再次被执行 -->*/
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

}
