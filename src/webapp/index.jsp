<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<header>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
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
        <li>
            <div class="link"><i class="fa fa-code"></i>子报表测试<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=1')">销售订单</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>JDBC数据源table控件<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=2')">销货单</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>javabean数据源table控件<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=3')">销货单</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>交叉报表<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=4')">货品分仓数量</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>javabean数据源图表饼图<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=5')">货物存储量</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>JDBC数据源图表柱状图<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=6')">货物存储量</a></li>
            </ul>
        </li>
        <li>
            <div class="link"><i class="fa fa-code"></i>group测试<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=7')">客户类型</a></li>
            </ul>
        </li>

        <li>
            <div class="link"><i class="fa fa-code"></i>image测试<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=8')">image</a></li>
            </ul>
        </li>

        <li>
            <div class="link"><i class="fa fa-code"></i>subTable测试<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li><a href="#" onclick="iframeChange('/report/japer?type=9')">sub_table_jdbc</a></li>
            </ul>
        </li>
    </ul>
</div>
<div class="main">
    <iframe id="reportFrame" width="100%" height="580px;"></iframe>
</div>
</body>
</html>
