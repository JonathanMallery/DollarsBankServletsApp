<%@ include file="header.jsp" %>
<div style="display: flex; flex-direction: row; align-items: center; justify-content: space-evenly; padding-top: 10px; background-color: tan">
	<div style="align-content: center; width: 33%">			
	</div>
	<div >
		<img style="width: 65%; margin: 0 auto;" alt="Money Picture" 
		src="https://www.washingtonpost.com/resizer/LgggStkyddK3qfFPzM3cO5Ch_aA=/
		1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/EBULPVFULQI6PG4TXFYEHZL2EI.jpg">
		<div style="align-content: center; width: 33%">
			<fieldset style="width: 190%">
				<legend style="margin: 0 auto;">Please Complete Below Fields</legend>
				<form action="" method="POST">
					<label>Firstname</label>
					<input type="text" placeholder="Enter Firstname" name="firstname" autocomplete="off" required><br>
					<label>Lastname</label>
					<input type="text" placeholder="Enter Lastname" name="lastname" required><br>
					<label>Username</label>
					<input type="text" placeholder="Enter Username" name="username" autocomplete="off" required><br>
					<label>Password</label>
					<input type="password" placeholder="Enter Password" name="password" required><br>
					<label>Deposit Amount</label>
					<input type="number" placeholder="Enter an amount" name="initial" autocomplete="off" required>
					<button class="btn" type="submit">Submit</button>
				</form>
				<button class="btn" type="button" onclick="location.href='homepage.jsp';" style="width: 130px; ">Back to Home</button>
			</fieldset>
		</div>
	</div>
	<div style="align-content: center; width: 33%">
	</div>
</div>
<%@ include file="footer.jsp" %>