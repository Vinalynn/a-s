package org.culliam.chooseit.web;

import org.apache.log4j.Logger;
import org.culliam.chooseit.dao.bean.HtmlDivConfig;
import org.culliam.chooseit.service.interfaces.HtmlDivConfigService;
import org.culliam.chooseit.util.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ����12:17
 */
public class DivHtmlHandler extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 143853430458338364L;
	private transient static Logger log = Logger.getLogger(DivHtmlHandler.class);
    private HtmlDivConfigService htmlDivConfigService;

    public void setHtmlDivConfigService(HtmlDivConfigService htmlDivConfigService) {
        this.htmlDivConfigService = htmlDivConfigService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> params = HttpUtils.getReqParams(req);
        resp.setContentType("text/html;charset=UTF-8");
        if(log.isDebugEnabled()){
            log.debug("Servlet Received >>>>>" + params);
        }
        HtmlDivConfig htmlDivConfig;
        try{
            htmlDivConfig = this.htmlDivConfigService.getDivContentByDivId(String.valueOf(params.get("div_id")));
            log.debug(htmlDivConfig);
            PrintWriter pw = resp.getWriter();
            pw.write(htmlDivConfig.getHtml_1());
        } catch (ServletException e){
            throw e;
        } catch (IOException e){
            throw e;
        } catch (Exception e){
            PrintWriter pw = resp.getWriter();
            pw.write(e.getMessage());
        }

    }
}
