<%@ page import="com.dollarsbank.model.Transaction" %>
<%@ page import="java.util.ArrayList" %>

<% ArrayList<Transaction> lf = (ArrayList<Transaction>) request.getAttribute("lft"); %>
<% if (lf!=null) {%>
<div>
	<table>
		<tbody>
			<tr>
				<td><%= lf.get(0).toString() %></td>
				<td><%= lf.get(1).toString() %></td>
				<td><%= lf.get(2).toString() %></td>
				<td><%= lf.get(3).toString() %></td>
				<td><%= lf.get(4).toString() %></td>
			</tr>
		</tbody>
	</table>
</div>
<% } %>