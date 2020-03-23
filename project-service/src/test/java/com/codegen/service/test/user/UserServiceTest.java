package com.codegen.service.test.user;

import com.codegen.dao.user.model.User;
import com.codegen.service.test.BaseTest;
import com.codegen.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务测试
 * @author KyrieCao
 * @date 2020/2/4 17:23
 */
@EnableAutoConfiguration
@SpringBootTest(classes = UserServiceTest.class)
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    /**
     * 创建
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    @Test
    @Transactional
    @Rollback
    public void createTest() {
        User user = new User();
        user.setNickname("测试用户");
        print(userService.create(user));
    }

    /**
     * 查询
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    @Test
    public void findTest() {
        User user = new User();
        user.setIsDelete(Boolean.FALSE);
        print(userService.find(user));
    }

    /**
     * 主键查询
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    @Test
    public void findByIdTest() {
        User user = userService.findById(1);
        print(user);
    }

    /**
     * 主键更新
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    @Test
    @Transactional
    @Rollback
    public void updateByIdTest() {
        User user = new User();
        user.setId(1);
        userService.updateById(user);
        print(null);
    }

    /**
     * 主键删除
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    @Test
    @Transactional
    @Rollback
    public void deleteByIdTest() {
        userService.deleteById(1);
        print(null);
    }

}
