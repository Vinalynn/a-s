package org.culliam.chooseit.dao.impl;

import org.culliam.chooseit.dao.bean.HtmlDivConfig;
import org.culliam.chooseit.dao.interfaces.HtmlDivConfigDao;
import org.culliam.chooseit.dao.mapper.HtmlDivConfigMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ÉÏÎç1:04
 */
public class HtmlDivConfigDaoImpl implements HtmlDivConfigDao {
    private HtmlDivConfigMapper htmlDivConfigMapper;

    public void setHtmlDivConfigMapper(HtmlDivConfigMapper htmlDivConfigMapper) {
        this.htmlDivConfigMapper = htmlDivConfigMapper;
    }

    @Override
    public List<HtmlDivConfig> getDivContentByDivId(String divId) throws Exception{
        return htmlDivConfigMapper.getHtmlDivConfigByDivId(divId);
    }
}
