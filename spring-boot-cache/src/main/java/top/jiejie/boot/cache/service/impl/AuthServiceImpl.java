package top.jiejie.boot.cache.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import top.jiejie.boot.cache.config.RedisCache;
import top.jiejie.boot.cache.config.RedisKeys;
import top.jiejie.boot.cache.exception.ErrorCode;
import top.jiejie.boot.cache.exception.ServerException;
import top.jiejie.boot.cache.service.AuthService;

import java.util.UUID;

/**
 * @Author yun
 * @Date: 2024/04/22/ 下午3:45
 * @description
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private RedisCache redisCache;

    @Override
    public String loginByPhone(String phone, String code) {
        // 获取验证码cacheKey
        String smsCacheKey = RedisKeys.getSmsKey(phone);
        // 从redis中获取验证码
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
        // 校验验证码合法性
        if (ObjectUtils.isEmpty(redisCode) || !redisCode.toString().equals(code)) {
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        // 删除用过的验证码
        redisCache.delete(smsCacheKey);
        // 返回token，这里用UUID模拟，实际上是要根据用户id，构造一个JWT Token
        return UUID.randomUUID().toString();
    }
}
