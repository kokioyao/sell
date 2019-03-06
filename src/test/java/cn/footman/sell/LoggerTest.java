package cn.footman.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author kokio
 * @create 2019-02-24 20:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test01(){
        String name = "testName";
        String password = "12345";
        log.info("info...");
        log.info("name: {}, password : {}",name,password);
        log.debug("debug...");
        log.error("error....");
    }

}
