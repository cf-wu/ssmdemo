package com.cfwu.mapper;

import com.cfwu.entity.User;

public interface IUserMapper {

/*    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);*/

    User selectByPrimaryKey(Integer id);

/*    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);*/
}
