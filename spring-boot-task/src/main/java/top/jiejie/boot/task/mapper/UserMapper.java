package top.jiejie.boot.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.jiejie.boot.task.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
