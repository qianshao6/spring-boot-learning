package top.jiejie.boot.fi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name="测试接口")
@RestController
@Slf4j
public class TestController {
    @GetMapping("/test")
    @Operation(summary = "测试接口")
    public String test() {
        return "hello world";
    }

}
