<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<!-- navigation -->
<c:set var="root" value="${pageContext.request.contextPath }" scope="request"></c:set>
<nav class="navbar navbar-expand-lg bg-light navbar-light d-flex justify-content-end">
	<ul class="nav nav-pills nav-fill ">
		<li class="nav-item"><a href="${root }/product" class="nav-link"><i class="bi bi-file-earmark"></i> Product</a></li>
	</ul>
	
</nav>
<!-- content -->
<main class="container mt-3 p-2">
	<jsp:doBody></jsp:doBody>
</main>
</body>
</html>
