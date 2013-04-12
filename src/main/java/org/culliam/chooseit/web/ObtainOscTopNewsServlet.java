package org.culliam.chooseit.web;

import org.culliam.chooseit.constdata.AppConst;
import org.culliam.chooseit.service.interfaces.OscContentSpiderService;
import org.json.JSONArray;

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
 * Time: 上午1:27
 * To change this template use File | Settings | File Templates.
 */
public class ObtainOscTopNewsServlet extends HttpServlet {
    private OscContentSpiderService oscContentSpiderService;

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

        if(null == topNewsJsonArray){
            try{
                topNewsJsonArray = this.oscContentSpiderService.oscHomePageTopNewsSpider();
            } catch(Exception e){
                topNewsJsonArray = new JSONArray();
            }
        }

        PrintWriter pw = resp.getWriter();
        pw.write(topNewsJsonArray.toString());
    }
}
