<%@ page import="org.culliam.chooseit.constdata.AppConst" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%--
  Created by IntelliJ IDEA.
  User: caiwm
  Date: 13-4-8
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>DeskTop-You Ask, I Answer</title>
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link href="/css/home.css" rel="stylesheet" type="text/css">
    <script src="/js/utils.js" type="text/javascript"></script>
    <script src="/js/json2.js" type="text/javascript"></script>
    <script src="/js/jquery-1.9.1.js" type="text/javascript"></script>
    <script src="/js/home.js" type="text/javascript"></script>

</head>

<%
    Object objUserId = session.getAttribute(AppConst.User.USER_ID);
    String userId = null == objUserId ? "-1" : String.valueOf(objUserId);

%>
<body>
<div id="h_container">
   <div id="h_content">
       <a href="javascript:showBtn()">展现导航栏</a> <br>
       <a href="javascript:testSendEmail()">SendEmail</a>
   </div>
    <%--<div style="clear:both;"></div>--%>
   <div id="h_dock">
       <div class="h_dock_sub" id="h_dock_sub_1">
            <a class="h_dock_sub_main_a">我的问题单</a>
            <a class="h_dock_sub_sub_a">还有<span style="color: #c71585">10</span>个提问没有回答！</a>
            <%--<span>sub_dock</span>--%>
       </div>
       <div class="h_dock_sub" id="h_dock_sub_2">
            <span>sub_dock</span>
       </div>
       <div class="h_dock_sub" id="h_dock_sub_3">
           <span>sub_dock</span>
       </div>
       <div class="h_dock_sub" id="h_dock_sub_4">
           <span>sub_dock</span>
       </div>
   </div>
</div>

</body>

</html>


<script type="text/javascript">
    var user_id = '<%=userId%>';
    //alert(user_id);

function showBtn(){
    //alert("showBtn111111");
    $("#h_container").animate({margin: '-300px 0 0 -480px;'},500).animate({height: '600px'},500, function(){fadeInDiv_500('h_dock',initSubDockContent);});
    //$("#h_dock").show(); initSubDockContent();
    //fadeInDiv_500('h_dock',initSubDockContent);
}
</script>