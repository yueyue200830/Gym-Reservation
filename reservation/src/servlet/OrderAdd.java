package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconns.OrderDAO;
import dbconns.OrderDAOImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class OrderAdd
 */
@WebServlet("/OrderAdd")
public class OrderAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		
		int usrID=(int)(request.getSession().getAttribute("usrID"));
		String ordName=request.getParameter("ordName");
		String rvnName=request.getParameter("rvnID");
		int rvnID = 0;
		if(rvnName.equals("篮球")) rvnID=1;
		else if(rvnName.equals("乒乓球")) rvnID=2;
		else if(rvnName.equals("羽毛球")) rvnID=3;
		else if(rvnName.equals("排球")) rvnID=4;
		String rvnRoomName=request.getParameter("rvnRoom");
		int rvnLength = rvnRoomName.length();
		int rvnRoom=rvnRoomName.charAt(rvnLength-1)-'0';
		String ordPhone=request.getParameter("ordPhone");
		double ordPrice=Double.valueOf(request.getParameter("ordPrice"));
		String rvnDate=request.getParameter("rvnDate");
		String rvnTiming=request.getParameter("rvnTime");
		int rvnTime = (rvnTiming.charAt(0)-'0')*10+rvnTiming.charAt(1)-'0'-12;
		//System.out.print("time=" + rvnTime);
		//int rvnTime=Integer.valueOf(request.getParameter("rvnTime"));
		
		OrderDAO od=new OrderDAOImpl();
		if(od.add(usrID, ordName, rvnID, rvnRoom, ordPhone, ordPrice, rvnDate, rvnTime)) {
			request.getRequestDispatcher("myorder.jsp").forward(request, response);
		} else {
			System.out.println("-- add order failed --");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('提交订单失败');");
			out.println("</script>");
			out.close();
			request.getRequestDispatcher("reservation.jsp").forward(request, response);
		}
	}

}
