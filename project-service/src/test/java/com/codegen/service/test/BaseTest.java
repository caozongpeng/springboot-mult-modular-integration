package com.codegen.service.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试基类
 * @author KyrieCao
 * @date 2020/2/4 17:23
 */
@Slf4j
@RunWith(SpringRunner.class)
@MapperScan("com.codegen.dao")
@ComponentScan("com.codegen")
public class BaseTest {
    /**
     * 打印测试结果
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    protected void print(Object obj) {
        log.info("测试结果: {}", obj == null ? "无返回" : JSON.toJSONString(obj));
    }
}
