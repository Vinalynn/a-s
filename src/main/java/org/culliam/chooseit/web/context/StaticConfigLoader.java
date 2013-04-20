package org.culliam.chooseit.web.context;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.culliam.chooseit.constdata.AppConst;
import org.culliam.chooseit.dao.bean.StaticConfig;
import org.culliam.chooseit.service.interfaces.StaticConfigService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-13
 * Time: aM 2:09
 */
public class StaticConfigLoader implements ServletContextListener {
    private transient Logger log = Logger.getLogger(StaticConfigLoader.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext applicationContext =
                WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());

        StaticConfigService staticConfigService = applicationContext.getBean(StaticConfigService.class);
        try{
            List<StaticConfig> configData = staticConfigService.getAllStaticConfig();
            for (StaticConfig staticConfig : configData) {
                sce.getServletContext().setAttribute(AppConst.StaticConfigKey.STATIC_CONFIG_CACHE_PREFIX +
                        staticConfig.getConfig_type(), staticConfig);
            }

            log.info("config data load successfully, total ["+configData.size()+"].");
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        @SuppressWarnings("unchecked")
		Enumeration<String> enumeration = sce.getServletContext().getAttributeNames();
        List<String> needDelAttrKeys = new ArrayList<String>(5);
        while(enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            if(StringUtils.startsWithIgnoreCase(key, AppConst.StaticConfigKey.STATIC_CONFIG_CACHE_PREFIX)){
                needDelAttrKeys.add(key);
            }
        }

        for (String needDelAttrName : needDelAttrKeys) {
              sce.getServletContext().removeAttribute(needDelAttrName);
        }
        log.info("config data removed successfully.");
    }
}
