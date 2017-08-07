<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <%-- <base href="<%=request.getContextPath()%>/"> --%>
    <title>login</title>
    <meta charset="utf-8">
    <%@include file="/com/script.jsp" %>
    <%@include file="/com/style.jsp" %>
    <style>
        .centerDiv {
            margin-top: 20px;
            margin-left: 5%;
            width: 500px;
        }

    </style>
</head>
<body>
<div class="centerDiv">
    <div>
        <ol class="breadcrumb">
            <li>获取报表</li>
            <li><a href="/report/japer${num}?type=excel">excel</a></li>
            <li><a href="/report/japer${num}?type=pdf">pdf</a></li>
            <li><a href="/report/japer${num}?type=html">html</a></li>
            <li><a href="/report/japer${num}?type=word">word</a></li>
        </ol>
    </div>
</div>
<div style="margin-top: 50px;border-top-color: #8c8c8c;border-top-style: solid;border-top-width: thin">
    <%--<iframe  width="100%" height="570" src="/report/japer3?type=html"></iframe>--%>
    <object style="border:0px;min-height:460px;" type="text/x-scriptlet" data="/report/japer${num}?type=html" width=100% ></object>
</div>
</body>
</html>
