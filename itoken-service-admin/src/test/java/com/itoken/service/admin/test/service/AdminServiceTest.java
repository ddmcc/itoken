package com.itoken.service.admin.test.service;

import com.itoken.service.admin.ServiceAdminApplication;
import com.itoken.service.admin.domain.TbSysUser;
import com.itoken.service.admin.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@ActiveProfiles(value = "prod")
@Transactional
@Rollback
public class AdminServiceTest {


    @Autowired
    private AdminService adminService;

    /**
     * 注册
     */
    @Test
    public void testRegister() {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setLoginCode("308119975@qq.com");
        tbSysUser.setUserName("ddmcc");
        tbSysUser.setUserType("1");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateBy(tbSysUser.getUserCode());
        Date date = new Date();
        tbSysUser.setCreateDate(date);
        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
        tbSysUser.setUpdateDate(date);
        tbSysUser.setCorpCode("0");
        tbSysUser.setCorpName("iToken");
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        adminService.register(tbSysUser);
    }

    /**
     * 登录
     */
    @Test
    public void testLogin() {
        TbSysUser tbSysUser = adminService.login("ddmcc", "123456");
        Assert.assertNotNull(tbSysUser);
    }
}
