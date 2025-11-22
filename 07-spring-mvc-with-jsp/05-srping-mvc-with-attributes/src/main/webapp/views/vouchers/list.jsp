<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<app:layout>
	<h3 class="mb-3">
		<i class="bi bi-cart"></i> Invoice Manager
	</h3>
	<table class="table table-borderd table-hover">
		<thead>
			<tr>
				<th></th>
				<th>UUID</th>
				<th class="text-end">Total Count</th>
				<th class="text-end">Total Amount</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${invList }" var="item" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${item.id }</td>
					<td class="text-end">${item.totalCount }</td>
					<td class="text-end">${item.totalAmount }</td>


				</tr>
			</c:forEach>
		</tbody>
		<tfooter>
			<tr>
				<td colspan="2" class="text-end">Total</td>
				<td class="text-end">${counts }</td>
				<td class="text-end">${amounts }</td>
			</tr>
		</tfooter>

	</table>

</app:layout>