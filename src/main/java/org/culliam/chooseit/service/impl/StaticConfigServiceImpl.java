package org.culliam.chooseit.service.impl;

import org.culliam.chooseit.dao.bean.StaticConfig;
import org.culliam.chooseit.dao.interfaces.StaticConfigDao;
import org.culliam.chooseit.service.interfaces.StaticConfigService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-13
 * Time: ÉÏÎç2:13
 */
public class StaticConfigServiceImpl implements StaticConfigService {
    private StaticConfigDao staticConfigDao;

    public void setStaticConfigDao(StaticConfigDao staticConfigDao) {
        this.staticConfigDao = staticConfigDao;
    }

    @Override
    public List<StaticConfig> getAllStaticConfig() throws Exception {
        return this.staticConfigDao.getAllStaticConfig();
    }
}
