<%@ include file="header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.dollarsbank.model.Customer" %>
<%@ page import="com.dollarsbank.model.Account" %>
<%@ page import="com.dollarsbank.model.Transaction" %>

<% ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("allCustomers"); %>
<% ArrayList<Account> accounts = (ArrayList<Account>) session.getAttribute("allAccounts"); %>
<% ArrayList<Transaction> transactions = (ArrayList<Transaction>) session.getAttribute("allTransactions"); %>
<% session.setAttribute("allCustomers",customers); %>
<% session.setAttribute("allAccounts",accounts); %>
<% session.setAttribute("allTransactions",transactions); %>

<div style="display: flex; flex-direction: row; align-items: center; justify-content: space-evenly; padding-top: 10px; background-color: tan">
	<div style="align-content: center; width: 33%">			
	</div>
	<div >
		<img style="width: 65%; margin: 0 auto;" alt="Money Picture" 
		src="https://www.washingtonpost.com/resizer/LgggStkyddK3qfFPzM3cO5Ch_aA=/
		1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/EBULPVFULQI6PG4TXFYEHZL2EI.jpg">
		<div style="align-content: center; width: 33%">
			<fieldset style="width: 190%">
				<legend style="margin: 0 auto;">Please Login</legend>
				<form action="LoginServlet" method="POST">
					<div>
					<% String message = (String) request.getAttribute("isVaild"); %>
					<% if (message != null) { %>
					<p style="color: red"><%=message%></p>
					<% } %>
					</div>
					<label>Username</label>
					<input type="text" placeholder="Enter Username" name="username" autocomplete="off" required><br>
					<label>Password</label>
					<input type="password" placeholder="Enter Password" name="password" required><br>
					<button class="btn" type="submit">Login</button>
				</form>
				<button class="btn" type="button" onclick="location.href='homepage.jsp';" style="width: 130px; ">Back to Home</button>
			</fieldset>
		</div>
	</div>
	<div style="align-content: center; width: 33%">
	</div>
</div>
<%@ include file="footer.jsp" %>