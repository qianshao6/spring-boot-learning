package top.jiejie.boot.file.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.jiejie.boot.file.model.dto.LoginUserDTO;
import top.jiejie.boot.file.model.entity.LoginUser;
import top.jiejie.boot.file.result.Result;
import top.jiejie.boot.file.service.LoginUserService;

import java.nio.channels.MulticastChannel;

@RestController
@RequestMapping(value = "user")
public class LoginUserController {
    @Resource
    private LoginUserService loginUserService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginUserDTO loginUserDTO) {
        LoginUser loginUser = loginUserService.login(loginUserDTO);
        return Result.ok(loginUser);
    }

    @PostMapping("/update")
    public Result<?> updateUser(@RequestBody LoginUser loginUser) {
        return Result.ok(loginUserService.update(loginUser));
    }
    @PostMapping("/upload")
    public String upload(MultipartFile file){
        return loginUserService.upload(file);
    }
}
