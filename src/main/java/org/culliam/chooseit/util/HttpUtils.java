package org.culliam.chooseit.util;


import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
     * 
     *
     * @param request
     * @return <code>HashMap<String, Object></code>
     */
    public static HashMap<String, Object> getReqParams(HttpServletRequest request) {
        HashMap<String, Object> params = new HashMap<String, Object>(2);
        @SuppressWarnings("unchecked")
		Enumeration<String> enumeration = request.getParameterNames();
        String key;
        while (enumeration.hasMoreElements()) {
            key = enumeration.nextElement();
            params.put(key, request.getParameter(key));
        }
        return params;
    }

    /**
     *
     * @param is
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String dump(InputStream is, String encoding) throws IOException {
        return IOUtils.toString(
                new BufferedReader(new InputStreamReader(is, encoding)));
    }

}
