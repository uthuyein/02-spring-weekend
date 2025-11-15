<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col col-3">
		<ul>
			<li class="nav-item" >
				<c:url var="request" value="/params/methodParam">
					<c:param name="day" value="WEDNESDAY"></c:param>
					<c:param name="value" value="40"></c:param>
				</c:url>
				<a class="nav-link" href="${request }">Request Params</a>
			</li>
			<li class="nav-item" ><a class="nav-link" href="${root }/params/form/get?type=get">Form Params</a></li>
			<li class="nav-item" ><a class="nav-link" href="${root }/params/form/get?type=post">Post Params</a></li>
			<li class="nav-item" ><a class="nav-link" href="${root }/params/path/hello path message">Path Params</a></li>
		</ul>
	</div>
	<div class="col">
		<jsp:doBody></jsp:doBody>
	</div>
</div>
