package top.jiejie.boot.cache.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jiejie.boot.cache.entity.dto.LoginInfo;
import top.jiejie.boot.cache.result.Result;
import top.jiejie.boot.cache.service.AuthService;

/**
 * @Author yun
 * @Date: 2024/04/22/ 下午9:09
 * @description
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public Result<Object> login(@RequestBody LoginInfo loginInfo){
        authService.loginByPhone(loginInfo.getPhoneNumber(), loginInfo.getVerificationCode());
        return Result.ok();
    }
}
