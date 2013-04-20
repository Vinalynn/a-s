package org.culliam.chooseit.web.context;

import org.apache.log4j.Logger;
import org.culliam.chooseit.constdata.AppConst;
import org.culliam.chooseit.dao.bean.StaticConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-13
 * Time: AM 12:44
 */
public class OscTopNewsRefresher implements ServletContextListener {
    private transient static Logger log = Logger.getLogger(OscTopNewsRefresher.class);

    private TopNewsRefreshTimer refreshTimer;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if(log.isInfoEnabled()){
            log.info("OscTopNewsRefresher start at " +
                    new Timestamp(new Date().getTime()).toString());
        }
        StaticConfig intervalTime = (StaticConfig)sce.getServletContext().
                getAttribute(AppConst.StaticConfigKey.STATIC_CONFIG_CACHE_PREFIX +
                        AppConst.StaticConfigKey.OSC_NEWS_INTERVAL);

        int interval = null == intervalTime ? 1 :
                (Integer.valueOf(intervalTime.getConfig_value()) < 1 ? 1 :
                        Integer.valueOf(intervalTime.getConfig_value()));

        refreshTimer = new TopNewsRefreshTimer(interval, sce.getServletContext());
        refreshTimer.start();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if(log.isInfoEnabled()){
            log.info("OscTopNewsRefresher end at " +
                    new Timestamp(new Date().getTime()).toString());
        }
        if(null != refreshTimer){
            refreshTimer.stop();
        }
    }
}
