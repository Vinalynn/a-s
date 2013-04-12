package org.culliam.chooseit.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.culliam.chooseit.service.interfaces.OscContentSpiderService;
import org.culliam.chooseit.util.HttpUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-12
 * Time: 下午4:32
 */
public class OscContentSpiderServiceImpl implements OscContentSpiderService {
    //private transient static Logger logger = Logger.getLogger(OscContentSpiderServiceImpl.class);
    private static String homeUri = "http://www.oschina.net";
    private static String homeUri_1 = "www.oschina.net";
    private static String homeUri_2 = "oschina.net";

    public void spy() throws Exception {

    }


    @Override
    public JSONArray oscHomePageTopNewsSpider() throws Exception {
        String htmlString =  entirePageSpider(homeUri);
        JSONArray industryNews = new JSONArray();
        //构造主页Document, 使用Jsoup
        Document document = Jsoup.parse(htmlString, homeUri);
        //首页综合资讯
        Element industryNewsElement = document.getElementById("IndustryNews");

        /*-START--特殊处理TodayNewsTop1----------*/
        Elements todayNewsTop1Div = industryNewsElement.getElementsByClass("TodayNewsTop1");
        Element todayNewsTop1A = todayNewsTop1Div.get(0).
                getElementsByTag("h2").get(0).getElementsByTag("a").get(0);
        String todayNewsTop1AOwnText = todayNewsTop1A.ownText();
        String todayNewsTop1AHref = addUri(homeUri, todayNewsTop1A.attr("href"));
        JSONObject todayNewsTop1 = new JSONObject();
        todayNewsTop1.put("text", todayNewsTop1AOwnText).put("href", todayNewsTop1AHref);
        industryNews.put(0, todayNewsTop1); //index-0 是topNews1
         /*-END---特殊处理TodayNewsTop1----------*/


        /*-START--处理UL-------------------------*/
        Elements industryUl = industryNewsElement.getElementsByTag("ul");
        JSONObject li_a_jObj;
        for (Element element : industryUl) {
             if(element.hasClass("p1")){
                 Elements lis = element.getElementsByTag("li");
                 for (Element li : lis) {
                     Element li_a = li.getElementsByTag("a").get(0);
                     li_a_jObj = new JSONObject();
                     li_a_jObj.put("text", li_a.ownText()).
                             put("href", addUri(homeUri, li_a.attr("href")));
                     industryNews.put(li_a_jObj);
                 }
             }
        }
        /*-END---处理UL-------------------------*/

        return industryNews;
    }

    /**
     * 抓取制定URL返回的所有数据
     * @param url
     * @return
     * @throws Exception
     */
    private String entirePageSpider(String url) throws Exception {
        if (!StringUtils.startsWithIgnoreCase(url, "http")
                ) url = "http://" + url;
        // use: Maven: org.apache.httpcomponents:httpclient:4.2.4
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) " +
                "AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.472.63 Safari/534.3");
        return HttpUtils.dump(
                httpClient.execute(httpGet).getEntity().getContent(),
                "UTF-8");
    }

    /**
     * 在相对路径上加上Uri
     * @param uri
     * @param href
     * @return
     */
    private String addUri(String uri, String href){
        if(StringUtils.contains(href, "homeUri_2")) return href;
        //if(StringUtils.contains(href, homeUri_1)) return href;
        return uri + href;
    }
}
