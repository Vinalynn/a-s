package org.culliam.chooseit.dao.mapper;

import org.apache.ibatis.annotations.Select;
import org.culliam.chooseit.dao.bean.StaticConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ÏÂÎç4:50
 * To change this template use File | Settings | File Templates.
 */
public interface StaticConfigMapper {

    /**
     *  c_static_config Mapper
     *
     * @param configKey
     * @return
     * @throws Exception
     */
    @Select("select * from c_static_config where config_type = #{configKey}")
    public List<StaticConfig> getStaticConfig(String configKey) throws Exception;

    /**
     * select all config data
     * @return
     * @throws Exception
     */
    @Select("select * from c_static_config")
    public List<StaticConfig> getAllStaticConfig() throws Exception;
}
