<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/4
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>文件列表</h1>

        <!--OGNL 对象导航图语言-->
        <s:iterator value="#request.files" var="f">
    <p>
        ====================
            <s:a href="down.do?filename=%{#f.name}">
                <s:property value="#f.name" ></s:property>
            </s:a>
    </p>
        </s:iterator>


</body>
</html>
