package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconns.UserDAO;
import dbconns.UserDAOImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class UserInformation
 */
@WebServlet("/UserInformation")
public class UserInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInformation() {
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("....this is information...");
		HttpSession session = request.getSession(true);
		String usrname = (String) session.getAttribute("usrName");
		System.out.println(usrname);
		
		UserDAO ud = new UserDAOImpl();
		String[] res = new String[2];
		res[0] = ud.findemail(usrname);
		res[1] = usrname;
		
		
		JSONArray array=JSONArray.fromObject(res);
		response.getWriter().write(array.toString());  
		//response.getWriter().print(usremail);
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
