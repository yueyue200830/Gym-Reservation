package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconns.OrderDAO;
import dbconns.OrderDAOImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class OrderAvailable
 */
@WebServlet("/OrderAvailable")
public class OrderAvailable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAvailable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("... in order-available servlet");
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int rvnID=Integer.valueOf(request.getParameter("rvnID"));
		String rvnDate=request.getParameter("rvnDate");
		//String rvnDate="2018-12-27";
		
		OrderDAO od=new OrderDAOImpl();
		int[][] avai=new int[4][8];
		avai=od.available(rvnID, rvnDate);
		
		
		System.out.println("-- order available success --");
		JSONArray array=JSONArray.fromObject(avai);
		response.getWriter().write(array.toString());  

	}

}
