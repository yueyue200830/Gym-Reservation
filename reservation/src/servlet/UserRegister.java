package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconns.UserDAO;
import dbconns.UserDAOImpl;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		System.out.println("... in user-register servlet");
		
		String usrName=request.getParameter("usrName");
		String usrKey=request.getParameter("usrKey");
		String usrEmail=request.getParameter("usrEmail");
		
		UserDAO ud = new UserDAOImpl();
		boolean findsame = ud.findsame(usrName);
		
		String message;
		if(findsame) {
			message="failure";
			return;
		}
		else {
			if(ud.register(usrName, usrKey, usrEmail)) 
				message="success";
			else 
				message="error";
		}
		
		System.out.println("-- register response " + message + " " + usrName +  " " +usrKey + " " + usrEmail + " --");
		response.getWriter().print(message);
		System.out.println(".....");
		
		
		/*
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Hello.jsp");
		dispatcher.forward(request, response);
		*/
	}
}
