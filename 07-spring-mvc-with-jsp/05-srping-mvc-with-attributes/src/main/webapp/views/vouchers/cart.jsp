<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<app:layout>
	<h3 class="mb-3"><i class="bi bi-cart"></i> Shopping Cart</h3>
	<table class="table table-borderd table-hover">
		<thead>
			<tr>
				<th></th>
				<th>Category</th>
				<th>Product</th>
				<th class="text-end">Price</th>
				<th class="text-end">Quentity</th>
				<th class="text-end">Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart.items }" var="item" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${item.product.category.name }</td>
					<td>${item.product.name }</td>
					<td class="text-end">${item.price }</td>
					<td class="text-end">${item.qty }</td>
					<td class="text-end">${item.qty*item.price }</td>
					
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4" class="text-end">Total</td>
				<td class="text-end">${cart.totalItems }</td>
				<td class="text-end">${cart.totalItemsAmount }</td>
			</tr>
		</tfoot>
	</table>
</app:layout>