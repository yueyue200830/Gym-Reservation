package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconns.UserDAO;
import dbconns.UserDAOImpl;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("... in user update");
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int usrID=(int)(request.getSession().getAttribute("usrID"));
		String usrName=request.getParameter("usrName");
		String usrKey=request.getParameter("usrKey");
		String usrEmail=request.getParameter("usrEmail");
		String usrOldKey=request.getParameter("usrOldKey");
		
		String message="failure";
		UserDAO ud=new UserDAOImpl();
		if(ud.check(usrID, usrOldKey) && ud.update(usrID, usrName, usrKey, usrEmail)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("usrName", usrName);  
			session.setAttribute("usrID",ud.findid(usrName));
			System.out.println("-- update user success --");
			message="success";
		}
		else
			message="failure";
		response.getWriter().print(message);
	}
}
