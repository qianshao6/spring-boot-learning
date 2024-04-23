package top.jiejie.boot.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;
import top.jiejie.boot.file.model.dto.LoginUserDTO;
import top.jiejie.boot.file.model.entity.LoginUser;

public interface LoginUserService extends IService<LoginUser> {
    LoginUser login(LoginUserDTO loginUserDTO);

    LoginUser update(LoginUser loginUser);

    String upload(MultipartFile file);
}
