package org.culliam.chooseit.util;


import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: 12:38 PM
 */
public class HttpUtils {

    /**
     * 把request里传过来的参数全部取出放到Map中
     *
     * @param request
     * @return <code>HashMap<String, Object></code>
     */
    public static HashMap<String, Object> getReqParams(HttpServletRequest request) {
        HashMap<String, Object> params = new HashMap<String, Object>(2);
        Enumeration<String> enumeration = request.getParameterNames();
        String key;
        while (enumeration.hasMoreElements()) {
            key = enumeration.nextElement();
            params.put(key, request.getParameter(key));
        }
        return params;
    }
}
