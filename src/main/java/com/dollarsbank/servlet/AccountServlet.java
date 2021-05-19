package com.dollarsbank.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollarsbank.controller.AccountController;
import com.dollarsbank.controller.TransactionController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.Transaction;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String selection = request.getParameter("selection");
		
		switch(selection) {
		case "deposit":
			deposit(request,response);
			break;
		case "withdraw":
			withdraw(request,response);
			break;
		case "transfer":
			transfer(request,response);
			break;
		case "customertransactions":
			customerTransactions(request,response);
			break;
		case "info":
			info(request,response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void deposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Account account = (Account) session.getAttribute("currentAccount");
		double balance = account.getBalance();
		double deposit = Double.parseDouble(request.getParameter("deposit"));
		
		account.setBalance(balance + deposit);
		session.setAttribute("currentAccount", account);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void withdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Account account = (Account) session.getAttribute("currentAccount");
		double balance = account.getBalance();
		double withdraw = Double.parseDouble(request.getParameter("withdraw"));
		
		account.setBalance(balance - withdraw);
		session.setAttribute("currentAccount", account);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
		
		dispatcher.forward(request, response);
		}
	
	private void transfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Account account = (Account) session.getAttribute("currentAccount");
		
		double balance = account.getBalance();
		double transfer = Double.parseDouble(request.getParameter("transfer"));
		
		account.setBalance(balance - transfer);
		session.setAttribute("currentAccount", account);
		
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		@SuppressWarnings("unchecked")
		ArrayList<Account> accounts = (ArrayList<Account>) session.getAttribute("accounts");
		AccountController acc = new AccountController(accounts);
		Account transferAccount = acc.findAccountByAccountId(accountId);
		
		double tbalance = transferAccount.getBalance();
		transferAccount.setBalance(tbalance + transfer);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
		
		dispatcher.forward(request, response);
		
		}
	
	private void customerTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Account account = (Account) session.getAttribute("currentAccount");
		@SuppressWarnings("unchecked")
		ArrayList<Transaction> transactions = (ArrayList<Transaction>) session.getAttribute("transactions");
		TransactionController tran = new TransactionController(transactions);
		
		ArrayList<Transaction> lastFive = tran.findLastFiveTransactionsByAccountId(account.getAccountId());
		request.setAttribute("lastfive", lastFive);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
		
		dispatcher.forward(request, response);
			
		}
	
	private void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("currentCustomer");
			
		request.setAttribute("customerInfo", customer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
		
		dispatcher.forward(request, response);
		}
}
