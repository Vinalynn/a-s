package org.culliam.chooseit.service.interfaces;

import org.culliam.chooseit.dao.bean.HtmlDivConfig;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ионГ1:07
 */
public interface HtmlDivConfigService {
    /**
     *
     * @param divId
     * @return
     */
    public HtmlDivConfig getDivContentByDivId(String divId) throws Exception;
}
