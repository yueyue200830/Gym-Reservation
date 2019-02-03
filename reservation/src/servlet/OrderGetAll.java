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

@WebServlet("/OrderGetAll")
public class OrderGetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderGetAll() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	doPost(request,response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //solve messy code when getting parameters
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		System.out.println("... in order-getall servlet");

		OrderDAO od=new OrderDAOImpl();
		List<String> allorders=od.getall();
		
		for(int i=0;i<allorders.size();i++) {
			System.out.print(allorders.get(i)+" ");
		}
		System.out.println("");
		
		JSONArray array=JSONArray.fromObject(allorders);
		response.getWriter().write(array.toString());  

	}

}
