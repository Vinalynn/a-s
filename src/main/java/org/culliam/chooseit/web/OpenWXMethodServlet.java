package org.culliam.chooseit.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.culliam.chooseit.constdata.AppConst;
import org.culliam.chooseit.util.HttpUtils;
import org.culliam.chooseit.util.SpellComparator;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-15
 * Time: 涓嬪崍8:11
 * To change this template use File | Settings | File Templates.
 */
public class OpenWXMethodServlet extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4272060357203239805L;
	private transient static Logger log = Logger.getLogger(OpenWXMethodServlet.class);

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();

        HashMap<String, Object> params = HttpUtils.getReqParams(req);
        if(log.isInfoEnabled()){
            log.info("Data-in:" + params);
        }

        List<String> list = new ArrayList<String>();
        list.add(String.valueOf(params.get("timestamp")));
        list.add(AppConst.extendInfo.WX_TOKEN);
        list.add(String.valueOf(params.get("nonce")));

        Collections.sort(list, new SpellComparator());

        StringBuilder sb = new StringBuilder(20);
        for(int i= 0; i<list.size();i++){
            sb.append(list.get(i));
        }

        MessageDigest md = null;
        String outStr = StringUtils.EMPTY;
        try{
            md = MessageDigest.getInstance("SHA-1");
            outStr = bytetoString(md.digest(sb.toString().getBytes()));
        } catch (Exception e){
            e.printStackTrace();
        }

        if(log.isInfoEnabled()){
            log.info("signature = ["+ String.valueOf(params.get("signature")) +"]");
            log.info("SHA-1=[" + outStr + "]");
        }

        if(StringUtils.endsWithIgnoreCase(outStr, StringUtils.substring(
                String.valueOf(params.get("signature")), 2, String.valueOf(params.get("signature")).length()))){
            if(log.isInfoEnabled()){
                log.info("return : [" + String.valueOf(params.get("echostr")) +"]");
            }
            pw.write(String.valueOf(params.get("echostr")));
        }else{
            pw.write("123");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        if(log.isInfoEnabled()){
            log.info("----user request received!!");
        }
        HashMap<String, Object> userRequest = HttpUtils.getReqParams(req);
        if (log.isInfoEnabled()) {
            log.info(userRequest);
        }

        String reqString = StringUtils.EMPTY;
        try{
            reqString = HttpUtils.dump(req.getInputStream(), "UTF-8");
            if(log.isInfoEnabled()){
                log.info(reqString);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        if(StringUtils.isNotEmpty(reqString)){
            try{
                Document doc = DocumentHelper.parseText(reqString);
                Element rootElement = doc.getRootElement();
                String content = rootElement.elementText("Content");
                String toUserName = rootElement.elementText("ToUserName");
                String fromUserName = rootElement.elementText("FromUserName");

                StringBuilder responseStr = new StringBuilder(50);
                responseStr.append("<xml>");
                responseStr.append("<ToUserName><![CDATA[").append(fromUserName).append("]]></ToUserName>");
                responseStr.append("<FromUserName><![CDATA[").append(toUserName).append("]]></FromUserName>");
                responseStr.append("<CreateTime>").append(System.currentTimeMillis()).append("</CreateTime>");
                
                if(StringUtils.isNotEmpty(content) && StringUtils.endsWithIgnoreCase("osc", content)){

                    responseStr.append("<MsgType><![CDATA[text]]></MsgType>");

                    //
//                    JSONArray topNewsJsonArray = (JSONArray) getServletContext().
//                            getAttribute(AppConst.extendInfo.OSC_TOP_NEWS_CONTEXT_KEY);

                    responseStr.append("<Content><![CDATA[").append("I Love U!!").append("]]></Content>");

                }else{
                    responseStr.append("<MsgType><![CDATA[text]]></MsgType>");

                    //
//                    JSONArray topNewsJsonArray = (JSONArray) getServletContext().
//                            getAttribute(AppConst.extendInfo.OSC_TOP_NEWS_CONTEXT_KEY);

                    responseStr.append("<Content><![CDATA[").append("我爱你！！").append("]]></Content>");
                }
                
                responseStr.append("<FuncFlag>0</FuncFlag></xml>");

                if(log.isInfoEnabled()){
                    log.info("response:["+ responseStr.toString()+"]");
                }
                resp.getWriter().write(new String(responseStr.toString().getBytes(), "UTF-8"));

            }catch (Exception e){
                e.printStackTrace();
            }


        }
        //BufferedReader br = new BufferedReader(new InputStreamReader(is));





    }


    private String bytetoString(byte[] digest) {
        String str = "";
        String tempStr = "";

        for (int i = 1; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            }
            else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }
}
