package com.dollarsbank.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
 * Servlet implementation class HomeServlet. This is the starting servlet that creates the 
 * Controllers and the objects within them
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerController cust;
	AccountController acc;
	TransactionController tran;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		cust = new CustomerController();
		acc = new AccountController();
		tran = new TransactionController(); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		//This is were all the data starts
		
		ArrayList<Customer> allCustomers = cust.getCustomers();
//		System.out.println("FROM THE HOMESERVLET " + Arrays.deepToString(allCustomers.toArray()));
		session.setAttribute("allCustomers", allCustomers);
		
		ArrayList<Account> allAccounts = acc.getAccounts();
		session.setAttribute("allAccounts", allAccounts);
		ArrayList<Transaction> allTransactions = tran.getTransactions();
		session.setAttribute("allTransactions", allTransactions);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(request, response);
	}

}
