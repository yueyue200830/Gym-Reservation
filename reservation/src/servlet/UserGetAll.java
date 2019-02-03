package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconns.UserDAO;
import dbconns.UserDAOImpl;
import net.sf.json.JSONArray;
import beans.User;

/**
 * Servlet implementation class UserGetAll
 */
@WebServlet("/UserGetAll")
public class UserGetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserGetAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		System.out.println("... in user-getall servlet");
		
		

		UserDAO ud = new UserDAOImpl();
		List<User> allusers = ud.getall();
		JSONArray array=JSONArray.fromObject(allusers);
		response.getWriter().write(array.toString());  
		/*
		request.setAttribute("allusers", allusers);
		request.getRequestDispatcher("/allusers.jsp").forward(request, response);
		*/
	}

}
