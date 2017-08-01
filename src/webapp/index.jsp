<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<header>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/angular.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        .lefttree {
            float: left;
            width: 230px;
            min-height: 60%;
            /*background-color: #ebcccc;*/
        }

        .main {
            margin-left: 230px;
            min-height: 80%;
            /*background-color: lightgoldenrodyellow;*/
        }
    </style>
    <script type="text/javascript">
        function iframeChange(url) {
            $('#reportFrame').attr("src", url);
        }
    </script>
</header>
<body>
<div class="lefttree">
    <ul id="accordion" class="accordion">
        <%--<li>
            <div class="link"><i class="fa fa-paint-brush"></i>Spring MVC<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="/report/japer?type=pdf" onclick="iframeChange('')">pdf</a></li>
                <li><a href="/report/japer?type=excel" onclick="iframeChange('')">excel</a></li>
                <li><a href="/report/japer2?type=pdf" onclick="iframeChange('')">pdf</a></li>
                <li><a href="/report/japer2?type=html" onclick="iframeChange('')">HTML</a></li>
            </ul>
        </li>--%>
        <li>
            <div class="link"><i class="fa fa-code"></i>response<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="/report/japer3?type=excel" onclick="iframeChange('')">excel</a></li>
                <li><a href="/report/japer3?type=pdf" onclick="iframeChange('')">pdf</a></li>
                <li><a href="/report/japer3?type=html" onclick="iframeChange('')">html</a></li>
                <li><a href="/report/japer3?type=word" onclick="iframeChange('')">word</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>javaBean<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="/report/japer5?type=excel" onclick="iframeChange('')">excel</a></li>
                <li><a href="/report/japer5?type=pdf" onclick="iframeChange('')">pdf</a></li>
                <li><a href="/report/japer5?type=html" onclick="iframeChange('')">html</a></li>
                <li><a href="/report/japer5?type=word" onclick="iframeChange('')">word</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>simple Sub Report<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer7')">销售订单</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>chart<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="/report/japer8?type=excel" onclick="iframeChange('')">excel</a></li>
                <li><a href="/report/japer8?type=pdf" onclick="iframeChange('')">pdf</a></li>
                <li><a href="/report/japer8?type=html" onclick="iframeChange('')">html</a></li>
                <li><a href="/report/japer8?type=word" onclick="iframeChange('')">word</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>chart2<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="/report/japer9?type=excel" onclick="iframeChange('')">excel</a></li>
                <li><a href="/report/japer9?type=pdf" onclick="iframeChange('')">pdf</a></li>
                <li><a href="/report/japer9?type=html" onclick="iframeChange('')">html</a></li>
                <li><a href="/report/japer9?type=word" onclick="iframeChange('')">word</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>tableTest<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="/report/japer10?type=excel" onclick="iframeChange('')">excel</a></li>
                <li><a href="/report/japer10?type=pdf" onclick="iframeChange('')">pdf</a></li>
                <li><a href="/report/japer10?type=html" onclick="iframeChange('')">html</a></li>
                <li><a href="/report/japer10?type=word" onclick="iframeChange('')">word</a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="main">
    <iframe id="reportFrame" width="100%" height="580px;"></iframe>
</div>
</body>
</html>
