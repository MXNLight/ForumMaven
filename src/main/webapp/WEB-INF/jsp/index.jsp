<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

response.setHeader("Charset","UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="list" method="post">
    <input type="submit" name="select" value="查询"/>
    </form>
    
    <form action="listone" method="post">
    <input type="text" name="selectid" value="admin" >
    <input type="submit" name="selectone" value="查询id"/>
    </form>
    
    <form action="insert" method="post">
    <input type="text" id="insertid" name="loginId" value="Alice" >
    <input type="text" id="insertpsd" name="loginPsd" value="Alice">
    <input type="submit" name="insert" value="插入"/>
    </form>
    
    <form action="delete" method="post">
    <input type="text" name="deleteid" value="Alice" >
    <input type="submit" name="deleteone" value="删除id"/>
    </form>
    
    <form action="updateindex" method="post">
    <input type="text" name="updateid" value="lqq" >
    <input type="submit" name="updateone" value="查询更新"/>
    </form>
    
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
    $(function(){
    $("#test").click(
    function(){
    //alert("进入function")
    $.ajax({
                url : "first/ajax",  
                type : "POST",  
                datatype:"json",  
                data : {"name":"宇枫"},
                scriptCharset: 'utf-8',
                success : function(msg) {
                    //alert(msg);
                    $("#testbook").attr("value",msg);// 填充内容
                     },
                error : function(msg) {
                     alert("net error");
                     }

    })
    });
    });
    </script>
    
    <input type="text" id="testbook" value="宇枫">
    <input type="submit" id="test" value="Ajax测试"/><br />
    
        <script type="text/javascript">
    function userajax(){
    //alert("进入function")
    var user = {
       loginId:$(loginId).text(),
       loginPsd:$(loginPsd).text()
    };  
    //params.XX必须与Spring Mvc controller中的参数名称一致    
    //否则在controller中使用@RequestParam绑定  
    $.ajax({
                url : "first/ajaxclass",  
                type : "POST",  
                datatype:"json",  
                data : JSON.stringify(user),
                contentType:'application/json;charset=UTF-8',
                scriptCharset: 'utf-8',
                success : function(msg) {
                    //alert(msg);
                    $("#insertid").attr("value",msg.loginId);// 填充内容
                    $("#insertpsd").attr("value",msg.loginPsd);
                     },
                error : function(msg) {
                     alert("net error");
                     }

    })
    };
    
    </script>
    <div id="loginId">风脩雨殇</div>
    <div id="loginPsd">Allen</div>
    <input type="button" value="Ajax类测试" onclick="userajax()" />
  </body>
</html>
