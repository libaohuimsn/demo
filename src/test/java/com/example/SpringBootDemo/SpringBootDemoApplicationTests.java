/*package com.example.SpringBootDemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mina.learn.bean.LearnResource;
import com.mina.learn.service.LearnService;

import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Autowired
    private LearnService learnService;

    @Test
    public void getLearn(){
        LearnResource learnResource=learnService.selectByKey(1001L);
        Assert.assertThat(learnResource.getAuthor(),is("嘟嘟MD独立博客"));
    }


    @Test
    @Transactional
//    @Rollback(false)
    public void add(){
        LearnResource bean = new LearnResource();
        bean.setAuthor("测试回滚");
        bean.setTitle("回滚用例");
        bean.setUrl("http://tengj.top");
        learnService.save(bean);
    }


}
*/