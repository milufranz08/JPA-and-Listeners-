package music.util;

import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MusicContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent event) {
	System.out.println("MusicContextListener destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
	System.out.println("MusicContextListener started");
    }
}
