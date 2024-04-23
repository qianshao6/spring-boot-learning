package top.jiejie.boot.file.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.jiejie.boot.file.exception.ServerException;
import top.jiejie.boot.file.mapper.LoginUserMapper;
import top.jiejie.boot.file.model.dto.LoginUserDTO;
import top.jiejie.boot.file.model.entity.LoginUser;
import top.jiejie.boot.file.service.LoginUserService;
import top.jiejie.boot.file.utils.OssTemplate;


@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserMapper, LoginUser> implements LoginUserService {
    @Resource
    private LoginUserMapper loginUserMapper;

    @Resource
    private OssTemplate ossTemplate;

    @Override
    public LoginUser login(LoginUserDTO loginUserDTO) {
        //根据传递的 loginUserDTO 中的手机号查询数据库中的用户信息
        LoginUser loginUser = loginUserMapper.selectOne(new LambdaQueryWrapper<LoginUser>().eq(LoginUser::getPhone, loginUserDTO.getPhone()));
        //查到了
        if (loginUser != null) {
            //比对md5加密后的密码
            String md5Password = DigestUtil.md5Hex(loginUserDTO.getPassword());
            if (loginUser.getPassword().equals(md5Password)) {
                return loginUser;
            } else {
                throw new ServerException("密码错误");
            }
        }
        throw new ServerException("手机号不存在");
    }

    @Override
    public LoginUser update(LoginUser loginUser) {
        this.updateById(loginUser);
        return loginUser;
    }

    @Override
    public String upload(MultipartFile file) {
        return ossTemplate.ossUpload(file);
    }

}