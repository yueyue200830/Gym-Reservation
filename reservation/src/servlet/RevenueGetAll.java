package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Revenue;
import dbconns.RevenueDAO;
import dbconns.RevenueDAOImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class RevenueGetAll
 */
@WebServlet("/RevenueGetAll")
public class RevenueGetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueGetAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		response.setCharacterEncoding("utf-8");
		System.out.println("... in revenue-getall servlet");

		RevenueDAO rd=new RevenueDAOImpl();
		List<Revenue> allrevenues=rd.getall();
		
		JSONArray array=JSONArray.fromObject(allrevenues);
		response.getWriter().write(array.toString());  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
