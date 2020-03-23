package com.codegen.service.user;

import com.codegen.core.model.Page;
import com.codegen.dao.user.model.TUser;
import com.codegen.dao.user.req.UserReq;
import com.codegen.dao.user.req.UserSaveReq;


/**
 * user业务接口定义
 * @author KyrieCao
 * @date 2020/02/04 14:59
 */
public interface UserService {

    /**
     * 用户分页列表
     * @param req       请求对象
     * @return Page<TUser>
     * @author KyrieCao
     * @date 2020/2/4 16:52
     */
    Page<TUser> findPage(UserReq req);

    /**
     * 根据ID查询
     * @author KyrieCao
     * @date 2020/02/04 14:59
     */
    TUser findById(Integer id);

    /**
     * 创建
     * @author KyrieCao
     * @date 2020/02/04 14:59
     */
    TUser create(UserSaveReq req);

    /**
     * 根据ID更新
     * @author KyrieCao
     * @date 2020/02/04 14:59
     */
    void updateById(UserSaveReq req);

    /**
     * 根据ID删除
     * @author KyrieCao
     * @date 2020/02/04 14:59
     */
    void deleteById(Integer id);
}