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
import com.dollarsbank.controller.CustomerController;
import com.dollarsbank.controller.TransactionController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.Transaction;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		@SuppressWarnings("unchecked")
		ArrayList<Account> accounts = (ArrayList<Account>) session.getAttribute("accounts");
		
		@SuppressWarnings("unchecked")
		ArrayList<Transaction> transactions = (ArrayList<Transaction>) session.getAttribute("transactions");
		
		@SuppressWarnings("unchecked")
		ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("customers");
		
		CustomerController cc = new CustomerController(customers);
		Customer customer = cc.findCustomerByUsername(username);
		session.setAttribute("currentCustomer", customer);
		session.setAttribute("customers", customers);
		
		AccountController acc = new AccountController(accounts);
		session.setAttribute("currentAccount", acc.findAccountByCustomerId(customer.getCustomerId()));
		session.setAttribute("accounts", accounts);
		
		TransactionController tran = new TransactionController(transactions);
		session.setAttribute("currentTransactions", tran.findTransactionsByAccountId(
													acc.findAccountByCustomerId(customer.getCustomerId()).getAccountId()));
		session.setAttribute("transactions", transactions);
		
		if (customer!=null && customer.getPassword().equals(password)) {
			session.setAttribute("uname", username);
			session.setAttribute("pwd", password);
			dispatcher=request.getRequestDispatcher("account.jsp");
		} else {
			request.setAttribute("isValid", "Login Credentials Are Incorrect");
			dispatcher=request.getRequestDispatcher("login.jsp");
		}
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
