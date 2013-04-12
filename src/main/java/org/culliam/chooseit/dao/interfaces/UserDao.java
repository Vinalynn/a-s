package org.culliam.chooseit.dao.interfaces;

import org.culliam.chooseit.dao.bean.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-2-26
 * Time: ионГ11:01
 */
public interface UserDao {

    public List<User> getAllUser() throws Exception;
}
