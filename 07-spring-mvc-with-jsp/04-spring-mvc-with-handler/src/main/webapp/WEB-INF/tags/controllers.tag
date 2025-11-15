<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col col-3">
		<ul>
			<li class="nav-item" ><a class="nav-link" href="${root }/controller">From addViewController method</a></li>
			<li class="nav-item" ><a class="nav-link" href="${root }/controller/redirect">From RedirectController method</a></li>
			<li class="nav-item" ><a class="nav-link" href="${root }/controller/legacy">From Legacy controller</a></li>
			<li class="nav-item" ><a class="nav-link" href="${root }/controller/router">From RouterFunction</a></li>
		</ul>
	</div>
	<div class="col">
		<jsp:doBody></jsp:doBody>
	</div>
</div>
