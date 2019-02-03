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
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("... in user-login servlet.....");
		
		String usrName = request.getParameter("usrName");
		String usrKey = request.getParameter("usrKey");
		
		UserDAO ud = new UserDAOImpl();
		
		if(ud.login(usrName, usrKey)){
			System.out.println("-- login success -------");
			String dest="";
			HttpSession session = request.getSession(true);  
			
		    System.out.println("检查用户类型...");
		    int usrType=ud.findtype(usrName);
		    System.out.println("登陆成功，用户类型："+usrType);
		    if(usrType==0) {
		    	request.setAttribute("user", usrName);
			    session.setAttribute("usrName", usrName);  
			    session.setAttribute("usrID",ud.findid(usrName));
			    dest="Hello.jsp";
		    }
		    else {
		    	request.setAttribute("user", usrName);
			    session.setAttribute("usrName", usrName);  
			    session.setAttribute("usrID",ud.findid(usrName));
		    	dest="managermain.jsp";
		    }

	    	request.getRequestDispatcher(dest).forward(request, response);
		}else{
			System.out.println("-- login failed --");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('用户名或密码错误');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
	}

}
