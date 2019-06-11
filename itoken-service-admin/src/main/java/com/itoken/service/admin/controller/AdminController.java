package com.itoken.service.admin.controller;

import com.google.common.collect.Lists;
import com.itoken.common.dto.BaseResult;
import com.itoken.service.admin.domain.TbSysUser;
import com.itoken.service.admin.service.AdminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(String loginCode, String password) {
        // 验证参数
        BaseResult baseResult = checkLogin(loginCode, password);
        if (null != baseResult) {
            return baseResult;
        }

        // 登录业务
        TbSysUser tbSysUser = adminService.login(loginCode, password);
        if (null == tbSysUser) {
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("", "账号或密码错误")));
        }
        return BaseResult.ok(tbSysUser);
    }


    /**
     * 登录参数校验
     *
     * @param loginCode     账号
     * @param password      密码
     * @return              BaseResult
     */
    private BaseResult checkLogin(String loginCode, String password) {
        List<BaseResult.Error> errors = Lists.newArrayList();

        if (StringUtils.isBlank(loginCode)) {
            errors.add(new BaseResult.Error("loginCode", "用户名不能为空"));
            return BaseResult.notOk(errors);
        }

        if (StringUtils.isBlank(password)) {
            errors.add(new BaseResult.Error("password", "密码不能为空"));
            return BaseResult.notOk(errors);
        }

        return null;
    }

}
