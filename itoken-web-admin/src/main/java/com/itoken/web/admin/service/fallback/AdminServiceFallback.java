package com.itoken.web.admin.service.fallback;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.itoken.common.constants.HttpStatusConstants;
import com.itoken.common.dto.BaseResult;
import com.itoken.web.admin.service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceFallback implements AdminService {


    @Override
    public String login(String loginCode, String password) {
        return JSONObject.toJSONString(BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(HttpStatusConstants.BAD_GATEWAY.getStatus()),
                        HttpStatusConstants.BAD_GATEWAY.getContent()))));
    }
}
