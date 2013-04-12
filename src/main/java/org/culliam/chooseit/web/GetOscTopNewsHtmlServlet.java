package org.culliam.chooseit.web;

import org.apache.commons.lang3.StringUtils;
import org.culliam.chooseit.constdata.AppConst;
import org.culliam.chooseit.dao.bean.HtmlDivConfig;
import org.culliam.chooseit.service.interfaces.HtmlDivConfigService;
import org.culliam.chooseit.service.interfaces.OscContentSpiderService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-13
 * Time: 上午4:26
 */
public class GetOscTopNewsHtmlServlet extends HttpServlet {
    private OscContentSpiderService oscContentSpiderService;
    private HtmlDivConfigService htmlDivConfigService;

    public void setHtmlDivConfigService(HtmlDivConfigService htmlDivConfigService) {
        this.htmlDivConfigService = htmlDivConfigService;
    }

    public void setOscContentSpiderService(OscContentSpiderService oscContentSpiderService) {
        this.oscContentSpiderService = oscContentSpiderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        //获取缓存中的topNews
        JSONArray topNewsJsonArray = (JSONArray) getServletContext().
                getAttribute(AppConst.extendInfo.OSC_TOP_NEWS_CONTEXT_KEY);

        StringBuilder html = new StringBuilder();

        if(null == topNewsJsonArray){
            try{
                topNewsJsonArray = this.oscContentSpiderService.oscHomePageTopNewsSpider();


            } catch(Exception e){
                e.printStackTrace();
            }
        }

        try{
            HtmlDivConfig htmlDivConfig =
                    this.htmlDivConfigService.getDivContentByDivId("osc_top_news_template");
            if(null != htmlDivConfig){
                html.append(htmlDivConfig.getHtml_1());   //ul
                String  li_tem;
                JSONObject li_object;
                for(int i=0,j=topNewsJsonArray.length();i<j;i++){
                    li_tem = htmlDivConfig.getHtml_2();
                    li_object = topNewsJsonArray.getJSONObject(i);
                    li_tem = StringUtils.replace(li_tem, "${href}", li_object.getString("href"));
                    li_tem = StringUtils.replace(li_tem, "${text}", li_object.getString("text"));
                    html.append(li_tem);
                }
                html.append(htmlDivConfig.getHtml_3()); //</ul>
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        PrintWriter pw = resp.getWriter();
        pw.write(html.toString());
    }
}
