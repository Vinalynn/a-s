package org.culliam.chooseit.service.impl;


import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.culliam.chooseit.service.interfaces.OscContentSpiderService;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-12
 * Time: ÏÂÎç4:32
 */
public class OscContentSpiderServiceImpl implements OscContentSpiderService {
    private transient static Logger logger = Logger.getLogger(OscContentSpiderServiceImpl.class);

    public void spy() throws Exception{
        CloseableHttpClient chc = HttpClientBuilder.create().build();
        HttpHost host = new HttpHost("www.oschina.net");

        HttpRequest request = new HttpGet();
        //request.
        CloseableHttpResponse response = chc.execute(host, request);
        InputStream is  = response.getEntity().getContent();
        logger.debug(is);
    }
}
