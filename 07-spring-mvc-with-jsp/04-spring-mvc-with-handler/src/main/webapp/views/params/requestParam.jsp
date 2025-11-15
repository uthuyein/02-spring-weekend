<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:layout>
	<h1>Hello params</h1>
	<app:sidebar>
		<h4>Requsest Params</h4>
		<table class="table table-bordered">
			<tr>
				<th>Day of Week</th>
				<td>${day }</td>
			</tr>
			<tr>
				<th>Count</th>
				<td>${value }</td>
			</tr>
		</table>
	</app:sidebar>
</app:layout>