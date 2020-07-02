<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市账单管理系统</title>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>超市账单管理系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" action="/loginServlet" method="post">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="name" id="name" placeholder="请输入用户名" required/>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="password" id="password" placeholder="请输入密码" required/>
                </div>
                <div class="subBtn">
                    <input type="submit" value="登录" />
                    <input type="reset" value="重置"/>
                </div>

            </form>
        </section>
    </section>

</body>
<%--<script>--%>
    <%--var flag;--%>
    <%--$(function(){--%>
        <%--$("#name").blur(function () {--%>
            <%--var code=$("#name").val();--%>
            <%--$.post(--%>
                <%--"/checkUserCodeServlet",//是ajax执行此函数跳转的页面--%>
                <%--{"code":code},//这是键值对形式的参数--%>
                <%--$(function (result) {--%>
                    <%--if (result) {--%>
                        <%--flag = true;--%>
                    <%--} else {--%>
                        <%--flag = false;--%>
                    <%--}--%>
                <%--}),//这是回调函数--%>
                <%--"json"//这是返回类型--%>
            <%--)--%>
        <%--});--%>
    <%--});--%>
    <%--function bbb() {--%>
        <%--if (flag) {--%>
            <%--location.href = "/loginServlet";--%>
        <%--}--%>
        <%--else {--%>
            <%--alert("用户名或密码错误");--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>

<script src="js/jquery.js"></script>
</html>