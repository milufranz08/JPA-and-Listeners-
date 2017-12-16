package music.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MusicRequestListener implements ServletRequestListener {
    
    public void requestDestroyed(ServletRequestEvent event) {
        ServletContext context = event.getServletContext();
	System.out.println("request being sent to "
			+ event.getServletRequest().getRemoteAddr());
    }
 
    public void requestInitialized(ServletRequestEvent event) {
	System.out.println("now initializing request"
			+ event.getServletRequest().getRemoteAddr());
 
    }
}
