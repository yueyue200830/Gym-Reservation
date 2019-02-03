package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Message;
import dbconns.MessageDAO;
import dbconns.MessageDAOImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class MessageGetAll
 */
@WebServlet("/MessageGetAll")
public class MessageGetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageGetAll() {
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
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("... in message-getall servlet");

		MessageDAO md=new MessageDAOImpl();
		List<Message> allmessages=md.getall();
		
		JSONArray array=JSONArray.fromObject(allmessages);
		response.getWriter().write(array.toString()); 
	}

}
