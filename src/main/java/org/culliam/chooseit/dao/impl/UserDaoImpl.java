package org.culliam.chooseit.dao.impl;

import org.culliam.chooseit.dao.bean.User;
import org.culliam.chooseit.dao.interfaces.UserDao;
import org.culliam.chooseit.dao.mapper.UserMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-2-26
 * Time: ионГ11:02
 */
public class UserDaoImpl implements UserDao {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUser() throws Exception{
        return userMapper.getAllUser();
    }
}
