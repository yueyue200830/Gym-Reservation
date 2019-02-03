package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Shopping
 */
@WebServlet("/Shopping")
public class Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String[] itemNames={"Oracle数据库","Mp5","饼干"};
	    HttpSession session=req.getSession(true);

	    ShoppingCart cart=(ShoppingCart) session.getAttribute("cart");

	    if (cart==null){
	      cart=new ShoppingCart();
	      session.setAttribute("cart",cart);
	    }

	    res.setContentType("text/html;charset=GB2312");
	    PrintWriter out=res.getWriter();


	    String[] itemsSelected;
	    String itemIndex; 
	    String itemName;  
	    itemsSelected=req.getParameterValues("item"); 
	    
	    if(itemsSelected !=null){
	      for(int i=0;i<itemsSelected.length;i++){
	        itemIndex=itemsSelected[i];  
	        itemName=itemNames[Integer.parseInt(itemIndex)];  
	        cart.add(itemName);
	      }

	    }

	 
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>shopping cart</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("Session ID:"+session.getId()+"<br>");
	 
	    out.println("<center><h1>你的购物车有"+cart.getNumberOfItems()+"个商品</h1></center>");
	    
	    Map<String,Integer> items=cart.getItems();
	    Iterator<Map.Entry<String,Integer>> it=items.entrySet().iterator();    
	    while(it.hasNext()){
	      Map.Entry entry=it.next();  //entry��ʾMap�е�һ�Լ���ֵ
	      out.println(entry.getKey()+": "+entry.getValue()+"<br>");
	    }
	    out.println("<br><a href='shopping.htm'>继续购物</a><br>");

	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
