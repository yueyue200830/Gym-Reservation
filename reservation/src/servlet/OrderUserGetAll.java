package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconns.OrderDAO;
import dbconns.OrderDAOImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class OrderUserGetAll
 */
@WebServlet("/OrderUserGetAll")
public class OrderUserGetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderUserGetAll() {
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
		System.out.println("... in order-usergetall servlet");
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int usrID=(int)(request.getSession().getAttribute("usrID"));
		
		OrderDAO od=new OrderDAOImpl();
		List<String> allorders=od.usergetall(usrID);
		
		JSONArray array=JSONArray.fromObject(allorders);
		response.getWriter().write(array.toString());  
	}

}
