package music.util;

import javax.servlet.*;
import javax.servlet.http.*;

public class SessionListener implements HttpSessionListener{
    
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        context.log(context.getServletContextName() + "has been created.");
    }
    
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        context.log(context.getServletContextName() + "has been destroyed.");
    }
}
