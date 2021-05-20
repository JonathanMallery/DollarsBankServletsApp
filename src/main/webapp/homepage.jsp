<%@ include file="header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.dollarsbank.model.Customer" %>
<%@ page import="com.dollarsbank.model.Account" %>
<%@ page import="com.dollarsbank.model.Transaction" %>

<div style="display: flex; align-items: center; justify-content: space-evenly; padding-top: 10px; background-color: tan">
	<div >
		<h2>Please Choose An Option</h2>
		<form >
			<% ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("allCustomers"); %>
			<% ArrayList<Account> accounts = (ArrayList<Account>) session.getAttribute("allAccounts"); %>
			<% ArrayList<Transaction> transactions = (ArrayList<Transaction>) session.getAttribute("allTransactions"); %>
			<% session.setAttribute("allCustomers", customers); %>
			<% session.setAttribute("allAccounts", accounts); %>
			<% session.setAttribute("allTransactions", transactions); %>
			<div style="align-items: center;">
				<button class="btn" type="button" onclick="location.href='login.jsp';" style="width: 130px; ">Login</button>
				<button class="btn" type="button" onclick="location.href='createAccount.jsp';" style="width: 130px">Create Account</button>
			</div>	
		</form>	
	</div>
	<div style="align-items: center">
		<img style="width: 65%; margin: 0 auto;" alt="Money Picture" 
		src="https://www.washingtonpost.com/resizer/LgggStkyddK3qfFPzM3cO5Ch_aA=/
		1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/EBULPVFULQI6PG4TXFYEHZL2EI.jpg">
	</div>
	<div style="align-content: center; width: 25%">
	</div>
</div>
<%@ include file="footer.jsp" %>