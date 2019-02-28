<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            // $.post("show", function (data) {
            //     console.log(data);
            //     var result = "";
            //     for (var i = 0; i < data.length; i++) {
            //         result += "<dl>";
            //         result += "<dt style='cursor:pointer'>" + data[i].name + "</dt>";
            //         if (data[i].children) {
            //             for (var j = 0; j < data[i].children.length; j++) {
            //                 result += "<dd>" + data[i].children[j].name + "</dd>";
            //             }
            //         }
            //         result += "</dl>";
            //     }
            //     $("#menu").html(result);
            // });

            //对所有父菜单添加点击事件
            //live("事件名,多个事件使用空格分割",function(){})
            $("dt").live("click", function () {
                //slow normal fast 数值
                $(this).siblings().slideToggle(300);
            });
        })
    </script>
</head>
<body>
<div style="text-align: center;">
    <a href="show">显示菜单</a>
    <a href="logout">退出登陆</a>
</div>
<div id="menu">
    <c:if test="${user.menuList!=null}">
        <c:forEach items="${user.menuList}" var="menu">
            <dl>
                <dt style="cursor:pointer">${menu.name}</dt>
                <c:if test="${menu.children!=null}">
                    <c:forEach items="${menu.children}" var="child">
                        <dd>${child.name}</dd>
                    </c:forEach>
                </c:if>
            </dl>
        </c:forEach>
    </c:if>
</div>
</body>
</html>