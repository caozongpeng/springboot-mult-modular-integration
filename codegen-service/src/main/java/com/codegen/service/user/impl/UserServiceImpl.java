package com.codegen.service.user.impl;
import com.codegen.core.model.PageData;
import com.codegen.core.utils.MyBatisUtil;
import com.codegen.dao.user.UserMapper;
import com.codegen.dao.user.model.User;
import com.codegen.dao.user.model.UserExample;
import com.codegen.service.user.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户表业务实现
 * @author KyrieCao
 * @date 2020/02/04 14:59
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageData<User> findPage(User user, PageData page, String orderByClause) {
        PageHelper.startPage(page.getPage(), page.getCapacity());
        UserExample example = MyBatisUtil.toExample(user, UserExample.class);
        example.setOrderByClause(orderByClause);
        return PageData.from(new PageInfo(userMapper.selectByExample(example)));
    }

    @Override
    public int create(User user) {
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        user.setIsDelete(Boolean.FALSE);
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> find(User user) {
        UserExample exam = new UserExample();
        UserExample.Criteria criteria = exam.createCriteria();
        if (user.getIsDelete() != null) {
            criteria.andIsDeleteEqualTo(user.getIsDelete());
        }
        return userMapper.selectByExample(exam);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(User user) {
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setIsDelete(Boolean.TRUE);
        this.updateById(user);
    }
}