<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<header>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/angular.min.js"></script>
    <script type="text/javascript" src="js/jqPaginator.js"></script>
    <script type="text/javascript">
        $.jqPaginator('#pagination1', {
            totalPages: 100,
            visiblePages: 10,
            currentPage: 3,
            onPageChange: function (num, type) {
                $('#p1').text(type + '：' + num);
            }
        });
        $.jqPaginator('#pagination2', {
            totalPages: 100,
            visiblePages: 10,
            currentPage: 3,
            prev: '<li class="prev"><a href="javascript:;">Previous</a></li>',
            next: '<li class="next"><a href="javascript:;">Next</a></li>',
            page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
            onPageChange: function (num, type) {
                $('#p2').text(type + '：' + num);
            }
        });

        function iframeChange(url){
            $('#reportFrame').attr("src",url);
        }
    </script>
    <style>
        .centerDiv{
            position: absolute;
            margin-top: 5%;
            margin-left: 30%;
            width: 500px;
            height: 300px;
            /*border-color: #1f1814;*/
            /*border-style: solid;*/
            /*border-radius: 3px;*/
            /*border-width: thin;*/
        }

        #reportFrame{
            position: absolute;
            margin-top: 15%;
            margin-left: 20%;
        }
    </style>
</header>
<body>

<div class="centerDiv">
    <div>
        jasperreport:
        <ol class="breadcrumb">
            <li>Spring MVC</li>
            <li><a href="/report/japer?type=pdf">pdf</a></li>
            <li><a href="/report/japer?type=excel">excel</a></li>
            <li><a href="/report/japer2?type=pdf">pdf</a></li>
            <li><a href="/report/japer2?type=html">HTML</a></li>
        </ol>
    </div>
    <div>
         <ol class="breadcrumb">
            <li>response</li>
            <li><a href="/report/japer3?type=excel">excel</a></li>
             <li><a href="/report/japer3?type=pdf">pdf</a></li>
             <li><a href="/report/japer3?type=html">html</a></li>
             <li><a href="/report/japer3?type=word">word</a></li>
        </ol>
    </div>
    <div>
        <ol class="breadcrumb">
            <li>jsp</li>
            <li><a href="#">pdf</a></li>
        </ol>
    </div>
    <div>
        FineReport:
        <ol class="breadcrumb">
            <li onclick="iframeChange('http://192.168.1.107:8075/WebReport/ReportServer?reportlet=myfirst.cpt')"><a href="#">myfirst</a></li>
            <li onclick="iframeChange('http://192.168.1.107:8075/WebReport/ReportServer?reportlet=myfirst.cpt')"><a href="#">myfirst</a></li>
            <li onclick="iframeChange('http://192.168.1.107:8075/WebReport/ReportServer?reportlet=myfirst.cpt')"><a href="#">myfirst</a></li>
        </ol>
    </div>
</div>
<div>
    <iframe id="reportFrame" width="900" height="400"></iframe>
</div>

</body>
</html>
