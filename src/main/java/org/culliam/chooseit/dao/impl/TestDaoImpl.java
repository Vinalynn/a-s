package org.culliam.chooseit.dao.impl;

import org.culliam.chooseit.dao.interfaces.TestDao;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-2-10
 * Time: ÏÂÎç8:10
 */
public class TestDaoImpl implements TestDao {
    //private transient Logger log = Logger.getLogger(TestDaoImpl.class);

    private MySQLMaxValueIncrementer idGenerator;

    public void setIdGenerator(MySQLMaxValueIncrementer idGenerator) {
        this.idGenerator = idGenerator;
    }


    @Override
    public long getNextLongId() throws Exception {
        return idGenerator.nextLongValue();
    }
}
