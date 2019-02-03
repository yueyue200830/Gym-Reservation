package mypack;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineCounterListener
 *
 */
@WebListener
public class OnlineCounterListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnlineCounterListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	HttpSession session=event.getSession();
        ServletContext context=session.getServletContext();
        Integer counter=(Integer)context.getAttribute("counter"); 
        if(counter==null)
          counter = 1;
        else
          counter = counter+1;

        context.setAttribute("counter",counter);
            //把会话的过期时间设为60秒
        session.setMaxInactiveInterval(60);
           System.out.println("A new session is created.");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	HttpSession session=event.getSession();
        ServletContext context=session.getServletContext();
        Integer counter=(Integer)context.getAttribute("counter"); 
        if(counter==null)
          return;
        else
          counter=counter-1;

        context.setAttribute("counter",counter);
        System.out.println("A new session is to be destroyed.");

    }
	
}
