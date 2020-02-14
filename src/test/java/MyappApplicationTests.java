import com.wdcloud.Application;
import com.wdcloud.mapper.OrgEmailMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)// 指定启动类
public class MyappApplicationTests {
    @Autowired
    OrgEmailMapper orgEmailMapper;
    @Test
    public void contextLoads() {
        List list=orgEmailMapper.selectAll();
        log.info("===>{}",list.size());
    }

}
