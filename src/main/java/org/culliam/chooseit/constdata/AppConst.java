package org.culliam.chooseit.constdata;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-10
 * Time: обнГ11:23
 */
public class AppConst {
    public interface User {
        public static String USER_ID = "_user_id";
    }

    public interface StaticConfigKey {
        public static String SERV_EMAIL_ADDR = "serv_email_addr";
        public static String OSC_NEWS_INTERVAL = "osc_news_interval";
        public static String STATIC_CONFIG_CACHE_PREFIX = "_SC_CACHE_PREFIX_";
    }

    public interface extendInfo {
        public static String OSC_TOP_NEWS_CONTEXT_KEY = "_OSC_TOP_NEWS_CONTEXT_KEY";
    }
}
