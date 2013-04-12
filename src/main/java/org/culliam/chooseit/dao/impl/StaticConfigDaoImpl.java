package org.culliam.chooseit.dao.impl;

import org.culliam.chooseit.dao.bean.StaticConfig;
import org.culliam.chooseit.dao.interfaces.StaticConfigDao;
import org.culliam.chooseit.dao.mapper.StaticConfigMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ÏÂÎç4:54
 * To change this template use File | Settings | File Templates.
 */
public class StaticConfigDaoImpl implements StaticConfigDao {
    private StaticConfigMapper staticConfigMapper;

    public void setStaticConfigMapper(StaticConfigMapper staticConfigMapper) {
        this.staticConfigMapper = staticConfigMapper;
    }

    @Override
    public List<StaticConfig> getStaticConfig(String configKey) throws Exception {
        return this.staticConfigMapper.getStaticConfig(configKey);
    }
}
