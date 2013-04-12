package org.culliam.chooseit.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 测试使用的获取应用上下文
 *
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-12
 * Time: 8:22 PM
 */
public class AppTestServiceFacotry {
    private final static ApplicationContext ac;
    static{
        ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
    }

    /**
     *  getService
     * @param serviceName
     * @return
     * @throws Exception
     */
    public static Object getService(String serviceName) throws Exception{
        return ac.getBean(serviceName);
    }

    public static Object getService(Class clazz){
       return ac.getBean(clazz);
    }
}
