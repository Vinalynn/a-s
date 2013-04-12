package org.culliam.chooseit.service.impl;

import org.apache.commons.mail.HtmlEmail;
import org.culliam.chooseit.constdata.AppConst;
import org.culliam.chooseit.dao.bean.StaticConfig;
import org.culliam.chooseit.dao.interfaces.StaticConfigDao;
import org.culliam.chooseit.service.interfaces.MailService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
public class MailServiceImpl implements MailService {
    private StaticConfigDao staticConfigDao;

    public void setStaticConfigDao(StaticConfigDao staticConfigDao) {
        this.staticConfigDao = staticConfigDao;
    }

    @Override
    public void sendHelloMail(long userId, String toEmailAddress,
                              String emailUserName, String emailPassword) throws Exception {

        HtmlEmail htmlEmail = new HtmlEmail();
        //从数据库获取服务邮箱配置
        //if(StringUtils.isEmpty(emailPassword) || StringUtils.isEmpty(emailUserName)){
            //获取服务邮箱配置
            List<StaticConfig> staticConfigs =
                    this.staticConfigDao.getStaticConfig(AppConst.StaticConfigKey.SERV_EMAIL_ADDR);

            if(null == staticConfigs || staticConfigs.size() < 1){
                throw new Exception("can not get serv email config!!");
            }
            emailUserName = staticConfigs.get(0).getConfig_value();
            emailPassword = staticConfigs.get(0).getConfig_value_ext_1();
       // }
        htmlEmail.setAuthentication(staticConfigs.get(0).getConfig_value(), staticConfigs.get(0).getConfig_value_ext_1());
        htmlEmail.setHostName(staticConfigs.get(0).getConfig_value_ext_2());
        htmlEmail.setSmtpPort(Integer.valueOf(staticConfigs.get(0).getConfig_value_ext_3()));
        //htmlEmail.setSSLCheckServerIdentity(Boolean.TRUE);
        //htmlEmail.setAuthenticator(new DefaultAuthenticator("username", "password"));
        htmlEmail.setSSLOnConnect(true);

        htmlEmail.addTo(toEmailAddress, emailUserName);
        htmlEmail.setFrom(emailUserName);
        htmlEmail.setSubject("Test Send Email from CloudFoundry1");
        htmlEmail.setCharset("GB2312");
        htmlEmail.setHtmlMsg("<html>这是封测试附件邮件</html>");
        htmlEmail.setSocketTimeout(10000);
        htmlEmail.send();
    }
}
