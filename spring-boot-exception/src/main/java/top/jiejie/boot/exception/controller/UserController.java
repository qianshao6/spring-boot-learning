package top.jiejie.boot.exception.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.jiejie.boot.exception.entity.User;
import top.jiejie.boot.exception.result.Result;

/**
 * @Author HHJ
 * @Date: 2024/04/08/ 14:45
 * @description
 */
@RestController
public class UserController {
    @PostMapping("/user/add")
    public Result<?> addUser(@Valid @RequestBody User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        return Result.ok(user);
    }
}
