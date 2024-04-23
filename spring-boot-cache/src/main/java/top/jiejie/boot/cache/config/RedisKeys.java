package top.jiejie.boot.cache.config;

public class RedisKeys {
    public static String getSmsKey(String phone) {
        return "sms:captcha" + phone;
    }
}
