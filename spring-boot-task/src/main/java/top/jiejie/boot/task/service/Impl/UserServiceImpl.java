package top.jiejie.boot.task.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.jiejie.boot.task.entity.User;
import top.jiejie.boot.task.mapper.UserMapper;
import top.jiejie.boot.task.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
