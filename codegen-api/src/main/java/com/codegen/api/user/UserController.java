package com.codegen.api.user;

import com.codegen.api.BaseController;
import com.codegen.core.model.ApiResponse;
import com.codegen.dao.user.model.User;
import com.codegen.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 示例Controller
 * @author KyrieCao
 * @date 2020/2/4 14:53
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户管理
     * @author KyrieCao
     * @date 2020/3/14 11:42
     */
    @GetMapping("/manage")
    @ApiOperation("用户管理页面")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView("user/manage");
        User req = new User();
        req.setIsDelete(Boolean.FALSE);
        List<User> users = userService.find(req);
        mav.addObject("userList", users);
        return mav;
    }

    /**
     * 创建用户
     * @author KyrieCao
     * @date 2020/3/14 11:43
     */
    @PostMapping("/create")
    @ApiOperation("创建用户")
    public ApiResponse<User> create(User user) {
        return ApiResponse.success(userService.create(user));
    }

    /**
     * 通过id查询用户
     * @author KyrieCao
     * @date 2020/3/14 21:36
     */
    @GetMapping("/{id}")
    @ApiOperation("根据ID查询")
    public ApiResponse<User> finById(@PathVariable Integer id) {
        return ApiResponse.success(userService.findById(id));
    }

    /**
     * 修改用户
     * @author KyrieCao
     * @date 2020/3/14 11:44
     */
    @PostMapping("/updateById")
    @ApiOperation("根据ID修改")
    public ApiResponse<User> updateById(User user) {
        userService.updateById(user);
        return ApiResponse.success(null);
    }

    /**
     * 用户删除
     * @author KyrieCao
     * @date 2020/3/14 11:45
     */
    @GetMapping("/delete/{id}")
    @ApiOperation("根据ID删除")
    public ApiResponse<?> delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ApiResponse.success(null);
    }
}
