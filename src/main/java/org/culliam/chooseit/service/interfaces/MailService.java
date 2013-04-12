package org.culliam.chooseit.service.interfaces;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: обнГ4:25
 */
public interface MailService {

    /**
     * Send hello Email to user
     * @param userId
     * @param emailUserName
     * @param emailPassword
     * @throws Exception
     */
    public void sendHelloMail(long userId, String toEmailAddress,
                              String fromEmailUserName, String emailPassword) throws Exception;
}
