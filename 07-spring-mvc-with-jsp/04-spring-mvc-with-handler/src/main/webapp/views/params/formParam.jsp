<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<app:layout>
	<h1>Hello params</h1>
	<app:sidebar>
		<h4>Form Params</h4>
		<c:choose>
			<c:when test="${type eq 'get' }">
				<form:form method="get" action="/params/form/get"
					cssClass="w-50 mb-3">
					<div class="form-group mb-3">
						<label for="message" class="form-label">Message</label> <input
							name="message" type="text" class="form-control" />
					</div>
					<div class="form-group mb-3">
						<label for="value" class="form-label">Value</label> <input
							name="value" type="text" class="form-control" />
					</div>
					<div class="form-group mb-3">
						<button class="btn btn-outline-primary">Send</button>
					</div>
				</form:form>
			</c:when>
			<c:otherwise>
				<form:form method="post" action="/params/form/post"
					cssClass="w-50 mb-3">
					<div class="form-group mb-3">
						<label for="message" class="form-label">Message</label> <input
							name="message" type="text" class="form-control" />
					</div>
					<div class="form-group mb-3">
						<label for="value" class="form-label">Value</label> <input
							name="value" type="text" class="form-control" />
					</div>
					<div class="form-group mb-3">
						<button class="btn btn-outline-primary">Send</button>
					</div>
				</form:form>
			</c:otherwise>
		</c:choose>


		<c:if test="${message ne null && value ne 0}">
			<table class="table table-borderd table-hover w-50">
				<tr>
					<th>Message</th>
					<td>${message}</td>
				</tr>
				<tr>
					<th>Value</th>
					<td>${value }</td>
				</tr>
			</table>
		</c:if>
	</app:sidebar>
</app:layout>