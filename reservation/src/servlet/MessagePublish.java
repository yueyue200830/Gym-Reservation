package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconns.MessageDAO;
import dbconns.MessageDAOImpl;

/**
 * Servlet implementation class MessagePublish
 */
@WebServlet("/MessagePublish")
public class MessagePublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessagePublish() {
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
		System.out.println("... in message update");
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int msgID=Integer.valueOf(request.getParameter("msgID"));
		MessageDAO md=new MessageDAOImpl();
		if(md.publish(msgID)) {
			request.getRequestDispatcher("managermessage.jsp").forward(request, response);
		}else{
			System.out.println("-- publish failed --");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('ͨ请求失败，请重试！');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
	}

}
