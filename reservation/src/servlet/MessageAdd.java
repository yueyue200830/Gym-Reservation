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
 * Servlet implementation class MessageAdd
 */
@WebServlet("/MessageAdd")
public class MessageAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageAdd() {
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
		
		String msgAuthor=request.getParameter("msgAuthor");
		String msgContent=request.getParameter("msgContent");
		MessageDAO md=new MessageDAOImpl();
		if(md.add(msgAuthor, msgContent)) {
			request.getRequestDispatcher("messageboard.jsp").forward(request, response);
		}else {
			System.out.println("-- add message failed --");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('留言失败！请重新留言！');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
	}

}
