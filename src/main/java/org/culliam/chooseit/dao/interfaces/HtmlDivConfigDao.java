package org.culliam.chooseit.dao.interfaces;

import org.culliam.chooseit.dao.bean.HtmlDivConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ионГ1:02
 * To change this template use File | Settings | File Templates.
 */
public interface HtmlDivConfigDao {

    /**
     *
     * @param divId
     * @return
     */
    public List<HtmlDivConfig> getDivContentByDivId(String divId) throws Exception;
}
