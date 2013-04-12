package org.culliam.chooseit.web.context;

import javax.servlet.ServletContext;
import java.util.Date;
import java.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-13
 * Time: ÉÏÎç12:46
 * To change this template use File | Settings | File Templates.
 */
public class TopNewsRefreshTimer {
    private final Timer timer = new Timer();
    private final int min;
    ServletContext context;

    public TopNewsRefreshTimer(int minutes, ServletContext context){
        this.min = minutes;
        this.context = context;
    }

    /**
     * run timer task
     */
    public void start(){
        timer.schedule(new TopNewsRefreshTask(context), new Date(), min * 60 * 1000);
    }

    /**
     * stop timer task
     */
    public void stop(){
        timer.cancel();
    }
}
