###概述
* springboot2.1.5
* maven启动: mvn spring-boot:run -D spring-boot.run.profiles=stable
* maven打包: mvn package -P stable

* 国际化参考https://blog.csdn.net/liujun03/article/details/82775634

* @Import https://blog.csdn.net/panchao888888/article/details/82882279
        https://www.cnblogs.com/haha12/p/11730357.html
        
* JWT https://cloud.tencent.com/developer/article/1495531
        
      https://mp.weixin.qq.com/s?__biz=MzI1NDY0MTkzNQ==&mid=2247485197&idx=1&sn=5f2358b0cdb45da37529f925253f8b76&scene=21#wechat_redirect
      
      配置路径规则时， /hello 接口必须要具备 user 角色才能访问， /admin 接口必须要具备 admin 角色才能访问，POST 请求并且是 /login 接口则可以直接通过，其他接口必须认证后才能访问。  