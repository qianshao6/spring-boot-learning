package top.jiejie.boot.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.jiejie.boot.file.model.entity.LoginUser;

@Mapper
public interface LoginUserMapper extends BaseMapper<LoginUser> {
}
