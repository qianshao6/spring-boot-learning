package top.jiejie.boot.mp.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jiejie.boot.mp.entity.UserDO;
import top.jiejie.boot.mp.mapper.UserMapper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() {
        UserDO userDO = new UserDO().setUsername("mjc").setPhone("1234567890").setGander("男");
        int rs = userMapper.insert(userDO);
        System.out.println(userDO.getId());

    }


    @Test
    void delete() {
        // 根据id删除
        // userMapper.deleteById(5);

        // 根据条件删除
        userMapper.delete(new LambdaQueryWrapper<UserDO>()
                .eq(UserDO::getUsername, "郑振"));
    }

    @Test
    void update() {
        // 1. 根据id更新
        userMapper.updateById(new UserDO()
                .setId(1)
                .setPhone("1234567890"));

        // 2. 根据条件更新
        userMapper.update(new UserDO().setUsername("伟康"), new LambdaQueryWrapper<UserDO>()
                .eq(UserDO::getPhone, "1234567890"));
        //3.不创建项目
        userMapper.update(
                null,
                new LambdaUpdateWrapper<UserDO>()
                        .set(UserDO::getCreateTime, LocalDateTime.now())
                        .set(UserDO::getDeleted, 1)
                        .eq(UserDO::getUsername, "宇涛")
        );
    }


}
