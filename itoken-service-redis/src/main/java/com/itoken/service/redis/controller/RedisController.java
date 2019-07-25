package com.itoken.service.redis.controller;

import com.alibaba.fastjson.JSONObject;
import com.itoken.common.dto.BaseResult;
import com.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public String put(String key, String value, long seconds) {
        redisService.put(key, value, seconds);
        return JSONObject.toJSONString(BaseResult.ok());
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String put(String key) {
        Object value = redisService.get(key);
        return JSONObject.toJSONString(BaseResult.ok(value));
    }

}
