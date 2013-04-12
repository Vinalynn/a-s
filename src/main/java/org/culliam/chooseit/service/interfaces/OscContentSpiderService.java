package org.culliam.chooseit.service.interfaces;

import org.json.JSONArray;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-12
 * Time: обнГ4:31
 */
public interface OscContentSpiderService {

    public void spy() throws Exception;

    public JSONArray oscHomePageTopNewsSpider() throws Exception;
}
