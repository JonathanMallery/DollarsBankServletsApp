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
       
//	CustomerController cust;
//	AccountController acc;
//	TransactionController tran;
	
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
//		cust = new CustomerController();
//		acc = new AccountController();
//		tran = new TransactionController(); 
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
		ArrayList<Account> accounts = (ArrayList<Account>) request.getAttribute("accounts");
		request.setAttribute("accounts",accounts);
		@SuppressWarnings("unchecked")
		ArrayList<Transaction> transactions = (ArrayList<Transaction>) request.getAttribute("transactions");
		request.setAttribute("transactions",transactions);
		
		@SuppressWarnings("unchecked")
		ArrayList<Customer> customers = (ArrayList<Customer>) request.getAttribute("customers");
		request.setAttribute("customers",customers);
		CustomerController cc = new CustomerController(customers);
		Customer customer = cc.findCustomerByUsername(username);
		
		
		
//		Customer customer = cust.findCustomerByUsername(username);
		request.setAttribute("currentCustomer", customer);
//		request.setAttribute("currentAccount", acc.findAccountByCustomerId(customer.getCustomerId()));
//		request.setAttribute("currentTransactions", tran.findTransactionsByAccountId(
//													acc.findAccountByCustomerId(customer.getCustomerId()).getAccountId()));
		
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
