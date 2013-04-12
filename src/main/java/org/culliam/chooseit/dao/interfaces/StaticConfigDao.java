package org.culliam.chooseit.dao.interfaces;

import org.culliam.chooseit.dao.bean.StaticConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: обнГ4:53
 */
public interface StaticConfigDao {

    /**
     *
     * @param configKey
     * @return
     * @throws Exception
     */
    public List<StaticConfig> getStaticConfig(String configKey) throws Exception;
}
