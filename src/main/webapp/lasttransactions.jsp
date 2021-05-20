<%@ page import="com.dollarsbank.model.Transaction" %>
<%@ page import="java.util.ArrayList" %>

<% ArrayList<Transaction> lf = (ArrayList<Transaction>) request.getAttribute("lft"); %>
<div>
	<table>
		<tbody>
			<tr>
				<td><%= lf.get(0).toString() %></td>
				<td><%= lf.get(1) %></td>
				<td><%= lf.get(2) %></td>
				<td><%= lf.get(3) %></td>
				<td><%= lf.get(4) %></td>
			</tr>
		</tbody>
	</table>
</div>