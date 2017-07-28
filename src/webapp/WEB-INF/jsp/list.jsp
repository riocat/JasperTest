<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@include file="/com/script.jsp"%>
<%@include file="/com/style.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<div>PageList</div>
	<div>
		<table class="table table-bordered">
			<caption>彩票</caption>
			<thead>
				<tr>
					<th>id</th>
					<th>no</th>
					<th>result</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lotterys}" var="lottery">
					<tr>
						<td>${lottery.id}</td>
						<td>${lottery.no}</td>
						<td>${lottery.resultString}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination" id="pagination1"></ul>
		<script type="text/javascript">
			var a = ${totalPages};
			var b = ${currentPage};
			$.jqPaginator('#pagination1', {
				totalPages : a,
				visiblePages : 10,
				currentPage : b,
				onPageChange : function(num, type) {
					if(type!='init'){
						location.href = "/page/toPage?next=" + num;
					}
				}
			});
		</script>
	</div>
</body>
</html>
