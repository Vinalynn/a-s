package org.culliam.chooseit.web;

import org.culliam.chooseit.service.interfaces.MailService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-11
 * Time: ÏÂÎç5:21
 * To change this template use File | Settings | File Templates.
 */
public class SendEmailServlet extends HttpServlet {
    private MailService mailService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try{
            this.mailService.sendHelloMail(-1, "william.cai@live.com", "", "");
            PrintWriter pw = resp.getWriter();
            pw.write("Send!");
        } catch (ServletException e){
            throw e;
        } catch (IOException e){
            throw e;
        } catch (Exception e){

            e.printStackTrace();
            PrintWriter pw = resp.getWriter();
            pw.write(e.getCause().toString());
        }
    }
}
