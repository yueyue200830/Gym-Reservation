package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.News;
import dbconns.NewsDAO;
import dbconns.NewsDAOImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class NewsGetAll
 */
@WebServlet("/NewsGetAll")
public class NewsGetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsGetAll() {
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
		System.out.println("... in news-getall servlet");

		NewsDAO nd=new NewsDAOImpl();
		List<News> allnews=nd.getall();

		JSONArray array=JSONArray.fromObject(allnews);
		response.getWriter().write(array.toString());  
	}

}
