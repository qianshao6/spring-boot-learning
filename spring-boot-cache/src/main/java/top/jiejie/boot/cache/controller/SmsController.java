package top.jiejie.boot.cache.controller;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.jiejie.boot.cache.result.Result;
import top.jiejie.boot.cache.service.SmsService;


@RestController
@RequestMapping("/sms")
@AllArgsConstructor
public class SmsController {
    @Resource
    private final SmsService smsService;

    @PostMapping("/send")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        smsService.sendSms(phone);
        return Result.ok();
    }

}