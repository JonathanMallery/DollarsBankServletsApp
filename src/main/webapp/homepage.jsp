<%@ include file="header.jsp" %>

<div style="display: flex; align-items: center; justify-content: space-evenly; padding-top: 10px; background-color: tan">
	<div >
		<h2>Please Choose An Option</h2>
		<form>
			<% request.setAttribute("customers",request.getAttribute("allCustomers")); %>
			<% request.setAttribute("accounts",request.getAttribute("allAccounts")); %>
			<% request.setAttribute("transactions",request.getAttribute("allTransactions")); %>
			<div style="align-items: center;">
				<button class="btn" type="button" onclick="location.href='login.jsp';" style="width: 130px; ">Login</button></br>
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