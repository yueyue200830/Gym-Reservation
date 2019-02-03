package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconns.OrderDAO;
import dbconns.OrderDAOImpl;

/**
 * Servlet implementation class OrderDelete
 */
@WebServlet("/OrderDelete")
public class OrderDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDelete() {
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
		System.out.println("... in order-add servlet");
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int ordID=Integer.valueOf(request.getParameter("ordID"));
		
		OrderDAO od=new OrderDAOImpl();
		String message="";
		if(od.delete(ordID)) {
			request.getRequestDispatcher("managerorder.jsp").forward(request, response);
		} else {
			System.out.println("-- delete order failed --");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('ͨ删除失败，请重试！');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		response.getWriter().write(message); 
	}

}
