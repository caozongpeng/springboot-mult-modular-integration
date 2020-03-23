package com.codegen.service.user;

import com.codegen.dao.user.model.User;
import java.util.List;

/**
 * 示例Service定义
 * @author KyrieCao
 * @date 2020/3/14 11:21
 */
public interface UserService {

    /**
     * 创建
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    int create(User user);

    /**
     * 查询
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    List<User> find(User user);

    /**
     * 主键查询
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    User findById(Integer id);

    /**
     * 主键更新
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    void updateById(User user);

    /**
     * 主键删除
     * @author Java助手
     * @date 2020/03/22 11:28
     */
    void deleteById(Integer id);
}