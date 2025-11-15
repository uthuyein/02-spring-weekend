<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
	<div class="col col-3">
		<ul>
			<li class="nav-item" ><a class="nav-link" href="${root }/returns/string">String Return</a></li>
			<li class="nav-item" ><a class="nav-link" href="${root }/returns/model">Model And View Return</a></li>
			<li class="nav-item" ><a class="nav-link" href="${root }/returns/noreturn">Void Return</a></li>
			<li class="nav-item" ><a class="nav-link" href="${root }/returns/redirect">Redirect Return</a></li>			
		</ul>
	</div>
	<div class="col">
		<jsp:doBody></jsp:doBody>
	</div>
</div>
