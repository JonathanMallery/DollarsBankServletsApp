<%@ include file="header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.dollarsbank.model.Customer" %>
<%@ page import="com.dollarsbank.model.Account" %>
<%@ page import="com.dollarsbank.model.Transaction" %>


<% Customer customer = (Customer) session.getAttribute("currentCustomer");  %>
<% Account account = (Account) session.getAttribute("currentAccount");  %>
<% Transaction transaction = (Transaction) session.getAttribute("currentTransactions");  %>
<div style="display: flex; align-items: center; justify-content: space-evenly; padding: 10px; background-color: tan">
	<div style="align-content: center; width: 33%">	
		<%-- --%>
		<h4>Hello, <%= customer.getFirstname() %> </h4>		
	</div>
	<div >
		<img style="width: 65%; margin: 0 auto;" alt="Money Picture" 
		src="https://www.washingtonpost.com/resizer/LgggStkyddK3qfFPzM3cO5Ch_aA=/
		1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/EBULPVFULQI6PG4TXFYEHZL2EI.jpg">
		<div style="align-content: center; width: 33%">
			<fieldset style="width: 190%">
				<legend style="margin: 0 auto;">Please Choose an option</legend>
				<%-- --%>
				<p style="color: blue">You have a balance of $<%= account.getBalance() %> </p>
				

				<form action="">
					<label>Deposit</label>
					<input type="hidden" name="selection" value="deposit">
					<input type="number" placeholder="Enter Amount" name="deposit">
					<button class="btn" type="submit" name="selection" value="deposit">Confirm</button>
				</form>
				<form action="">
					<label>Withdraw</label>
					<input type="hidden" name="selection" value="withdraw">
					<input type="number" placeholder="Enter Amount" name="withdraw">
					<button class="btn" type="submit" name="selection" value="withdraw">Confirm</button>
				</form>
				<form action="">
					<label>Funds Transfer</label>
					<input type="hidden" name="selection" value="transfer">
					<input type="number" placeholder="Enter Amount" name="transfer">
					<input type="number" placeholder="Enter Account Number" name="acountId">
					<button class="btn" type="submit" name="selection" value="transfer">Confirm</button>
				</form>
				<form action="">
					<label>Last 5 Transactions</label>
					<input type="hidden" name="selection" value="customertransactions">
					<% request.setAttribute("lft", request.getAttribute("lastfive"));  %>
					<%@ include file="lasttransactions.jsp" %>
					<button class="btn" type="submit" name="selection" value="customertransactions">Confirm</button>
				</form>
				
					<label>Customer Info</label>
					<input type="hidden" name="selection" value="info">

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
									<td><%= customer.getCustomerId() %></td>
									<td><%= customer.getFirstname()%> <%= customer.getLastname() %></td>
									<td><%= customer.getUsername() %></td>
									<td><%= customer.getPassword() %></td>
								</tr>
							</tbody>
						</table>
					</div>
				<button class="btn" type="button" onclick="location.href='homepage.jsp';" style="width: 130px; ">Login</button>
			</fieldset>
		</div>
	</div>
	<div style="align-content: center; width: 33%">
	</div>
</div>

<%@ include file="footer.jsp" %>