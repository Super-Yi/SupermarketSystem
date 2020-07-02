<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${admin.userName}</span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.jsp">账单管理</a></li>
                <li ><a href="providerList.jsp">供应商管理</a></li>
                <li id="active"><a href="userList.jsp">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="/updateUserServlet" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="id" value="${id}">
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${user.userName}" placeholder="请输入用户名称"/>
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>
                    <c:if test="${user.gender == 1}">
                    <select name="gender">
                        <option value="男" name="gender">男</option>
                        <option value="女" name="gender" selected>女</option>
                    </select>
                    </c:if>
                    <c:if test="${user.gender == 2}">
                        <select name="gender">
                            <option value="男" name="gender" selected>男</option>
                            <option value="女" name="gender">女</option>
                        </select>
                    </c:if>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" name="birthday" id="birthday" value="${user.birthday}" placeholder="请输入日期"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="${user.phone}" placeholder="请输入电话"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                    <input type="text" name="address" id="address" value="${user.address}" placeholder="请输入地址"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <c:if test="${user.userRole == 1}">
                        <input type="radio" value="管理员" name="userRole" checked/>管理员
                        <input type="radio" value="经理" name="userRole"/>经理
                        <input type="radio" value="普通用户" name="userRole"/>普通用户
                    </c:if>
                    <c:if test="${user.userRole == 2}">
                        <input type="radio" value="管理员" name="userRole"/>管理员
                        <input type="radio" value="经理" name="userRole" checked/>经理
                        <input type="radio" value="普通用户" name="userRole"/>普通用户
                    </c:if>
                    <c:if test="${user.userRole == 3}">
                        <input type="radio" value="管理员" name="userRole"/>管理员
                        <input type="radio" value="经理" name="userRole"/>经理
                        <input type="radio" value="普通用户" name="userRole" checked/>普通用户
                    </c:if>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>