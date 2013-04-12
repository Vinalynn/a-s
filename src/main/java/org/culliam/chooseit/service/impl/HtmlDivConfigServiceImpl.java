package org.culliam.chooseit.service.impl;

import org.culliam.chooseit.dao.bean.HtmlDivConfig;
import org.culliam.chooseit.dao.interfaces.HtmlDivConfigDao;
import org.culliam.chooseit.service.interfaces.HtmlDivConfigService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ÉÏÎç1:08
 * To change this template use File | Settings | File Templates.
 */
public class HtmlDivConfigServiceImpl implements HtmlDivConfigService {
    private HtmlDivConfigDao htmlDivConfigDao;

    public void setHtmlDivConfigDao(HtmlDivConfigDao htmlDivConfigDao) {
        this.htmlDivConfigDao = htmlDivConfigDao;
    }

    @Override
    public HtmlDivConfig getDivContentByDivId(String divId) throws Exception{
        List<HtmlDivConfig> list = this.htmlDivConfigDao.getDivContentByDivId(divId);
        if(null == list) return null;
        if(list.size() < 1) return null;
        return list.get(0);
    }
}
