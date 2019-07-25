package com.itoken.service.redis.service;

/**
 *
 * @author ddmcc
 *
 */

public interface RedisService {

    /**
     *
     *
     * @param key       键
     * @param value     值
     * @param seconds  超时时间
     */
    void put(String key, Object value, long seconds);


    /**
     *
     *
     * @param key 键
     */
    Object get(String key);

}
