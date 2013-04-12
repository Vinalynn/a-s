package org.culliam.chooseit.dao.mapper;

import org.apache.ibatis.annotations.Select;
import org.culliam.chooseit.dao.bean.HtmlDivConfig;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ионГ12:58
 */
public interface HtmlDivConfigMapper {

    @Select("select id, div_id, html_1, html_2, html_3, html_4 from c_html_div_config where div_id = #{divId}")
    List<HtmlDivConfig> getHtmlDivConfigByDivId(String divId) throws Exception;
}
