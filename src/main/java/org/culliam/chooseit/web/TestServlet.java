package org.culliam.chooseit.web;

import org.culliam.chooseit.service.interfaces.TestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-2-10
 * Time: 8:18 PM
 */
public class TestServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6065167301871136441L;
	private TestService testService;

    public void setTestService(TestService testService){
        this.testService = testService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("new seq : " + testService.testIdGenerator());





            //testService.testIdGenerator();
        } catch (ServletException e){
            throw e;
        } catch (IOException ioe){
            throw ioe;
        } catch (Exception e){

        }
    }
}
