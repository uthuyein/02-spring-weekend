<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:layout>
	<h3>Product List</h3>
	<form action="${root }/product/search">
		<div class="row g-3 align-items-center">
			<div class="<col-6></col-6>">
				<input type="text" class="form-control" placeholder="Search ..." />
			</div>
			<div class="col-auto">
				<button class="btn btn-outline-primary">
					<i class="bi bi-search"></i>
				</button>

			</div>
			<div class="col-auto">
				<a href="${root }/product/add" class="btn btn-outline-success"><i
					class="bi bi-plus"></i></a>
			</div>
		</div>
	</form>


</app:layout>