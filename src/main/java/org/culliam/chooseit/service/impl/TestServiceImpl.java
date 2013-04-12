package org.culliam.chooseit.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.culliam.chooseit.dao.bean.User;
import org.culliam.chooseit.dao.interfaces.TestDao;
import org.culliam.chooseit.dao.interfaces.UserDao;
import org.culliam.chooseit.service.interfaces.TestService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-2-10
 * Time: ÏÂÎç8:01
 */
public class TestServiceImpl implements TestService {
    private transient Logger log = Logger.getLogger(TestServiceImpl.class);
    private TestDao testDao;
    private UserDao userDao;

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public long testIdGenerator() throws Exception {
        log.debug(RandomStringUtils.random(20, Boolean.TRUE, Boolean.TRUE));

        List<User> userList = userDao.getAllUser();
        for (User user : userList) {
            log.debug(user.getUserId() + " | "+user.getEmail() + " | " + user.getCreateDate() + " | " + user.getPassword());
        }
        return testDao.getNextLongId();
    }
}
