package com.cfwu.service.imp;

import com.cfwu.entity.User;
import com.cfwu.mapper.IUserMapper;
import com.cfwu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
