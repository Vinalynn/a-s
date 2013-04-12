package org.culliam.chooseit.service.interfaces;

import org.culliam.chooseit.dao.bean.StaticConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-13
 * Time: ионГ2:12
 */
public interface StaticConfigService {

    /**
     *
     * @return
     * @throws Exception
     */
    public List<StaticConfig> getAllStaticConfig() throws Exception;
}
