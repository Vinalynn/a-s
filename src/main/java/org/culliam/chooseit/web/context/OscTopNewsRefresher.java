package org.culliam.chooseit.web.context;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-13
 * Time: ÉÏÎç12:44
 * To change this template use File | Settings | File Templates.
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

        refreshTimer = new TopNewsRefreshTimer(1, sce.getServletContext());
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
