package org.culliam.chooseit.service.impl;


import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.ConnectionBackoffStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultBackoffStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
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

    public void spy() throws Exception {
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        clientBuilder.setConnectionBackoffStrategy(new DefaultBackoffStrategy());

        CloseableHttpClient chc = clientBuilder.build();

        HttpHost host = new HttpHost("www.oschina.net");

        HttpRequest request = new HttpPost();

        CloseableHttpResponse response = chc.execute(host, request);
        InputStream inputStream = response.getEntity().getContent();
        int count = 0;
        while (count == 0) {
            count = inputStream.available();
        }
        byte[] b = new byte[count];
        inputStream.read(b);

        logger.error(new String(b, "utf-8"));

    }
}
