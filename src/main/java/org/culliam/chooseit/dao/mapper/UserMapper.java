package org.culliam.chooseit.dao.mapper;

import org.apache.ibatis.annotations.Select;
import org.culliam.chooseit.dao.bean.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-2-26
 * Time: ионГ10:51
 */
public interface UserMapper {

    @Select("select user_id as userId, sex_type as sexType, email, state, create_date, password from i_user")
    List<User> getAllUser();

}
