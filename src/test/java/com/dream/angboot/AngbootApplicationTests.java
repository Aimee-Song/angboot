package com.dream.angboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AngbootApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        Assert.assertNotNull("ApplicationContext has not been initialization...", applicationContext);
    }

}
