package org.culliam.chooseit.service;


import org.culliam.chooseit.factory.AppTestServiceFacotry;
import org.culliam.chooseit.service.interfaces.OscContentSpiderService;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-12
 * Time: 8:28 PM
 */
public class TestOscContentSpiderService {


    /**
     * 测试的 我会乱说吗
     * @throws Exception
     */
    @Test
    public void testHttpClient() throws Exception{
        OscContentSpiderService service =
                (OscContentSpiderService) AppTestServiceFacotry.getService(OscContentSpiderService.class);
        service.spy();

    }

}
