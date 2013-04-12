package org.culliam.chooseit.web.context;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.log4j.Logger;
import org.culliam.chooseit.constdata.AppConst;
import org.culliam.chooseit.service.interfaces.OscContentSpiderService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-13
 * Time: ÉÏÎç12:47
 * To change this template use File | Settings | File Templates.
 */
public class TopNewsRefreshTask extends TimerTask {

    ServletContext context;

    private transient static Logger log = Logger.getLogger(TopNewsRefreshTask.class);

    public TopNewsRefreshTask(ServletContext context){
        this.context = context;
    }

    @Override
    public void run() {
        //context.setAttribute();
        log.info("---------[oschina.net] top news refreshed at " + new Timestamp(new Date().getTime()).toString());
        try{
            ApplicationContext applicationContext =
                    WebApplicationContextUtils.getRequiredWebApplicationContext(context);

            OscContentSpiderService service = applicationContext.getBean(OscContentSpiderService.class);
            context.setAttribute(AppConst.extendInfo.OSC_TOP_NEWS_CONTEXT_KEY, service.oscHomePageTopNewsSpider());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
