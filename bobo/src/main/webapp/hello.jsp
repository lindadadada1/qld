<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#submit").click(function () {
                $("#myFrom").submit();
            })
        })
    </script>
</head>
<body>
<h3>我是初始页呦</h3>
<form action="/bobo/form2" method="post" id="myFrom">
    请输入姓名: <input type="text" name="name">
    请输入年龄: <input type="text" name="age">
    请输入性别: <input type="text" name="sex">
</form>
<button id="submit">提交</button>
微语言: ${msg}

</body>
</html>