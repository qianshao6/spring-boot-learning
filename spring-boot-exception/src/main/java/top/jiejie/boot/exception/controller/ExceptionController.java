package top.jiejie.boot.exception.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.jiejie.boot.exception.service.MyService;


/**
 * @Author HHJ
 * @Date: 2024/04/08/ 14:26
 * @description
 */
@RestController
public class ExceptionController {
    @Resource
    public MyService myService;

    @GetMapping("/user/{id}")
    public void getUser(@PathVariable("id") Integer id) {
        if(id == 1) {
            myService.unAuthorizedError();
        } else {
            myService.serverError();
        }
    }
}

