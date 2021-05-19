<%@ page import="com.dollarsbank.model.Customer" %>

<% Customer customerInfo = (Customer) request.getAttribute("ci"); %>
<div>
	<table>
		<thead>
			<tr>
				<th scope="row">Customer Id: </th>
				<th scope="row">Customer Name: </th>
				<th scope="row">Username: </th>
				<th scope="row">Password: </th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%= customerInfo.getCustomerId() %></td>
				<td><%= customerInfo.getFirstname()%> <%= customerInfo.getLastname() %></td>
				<td><%= customerInfo.getUsername() %></td>
				<td><%= customerInfo.getPassword() %></td>
			</tr>
		</tbody>
	</table>
</div>