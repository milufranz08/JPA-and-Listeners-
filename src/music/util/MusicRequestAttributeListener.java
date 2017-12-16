package music.util;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MusicRequestAttributeListener implements ServletRequestAttributeListener{
    
    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        String attributeName = event.getName();
	Object attributeValue = event.getValue();
	System.out.println("Attribute added : " + attributeName + " : "
				+ attributeValue);
    }
 
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        String attributeName = event.getName();
	Object attributeValue = event.getValue();
	System.out.println("Attribute removed : " + attributeName + " : "
				+ attributeValue);
    }
 
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        String attributeName = event.getName();
	Object attributeValue = event.getValue();
	System.out.println("Attribute replaced : " + attributeName + " : "
				+ attributeValue);
    } 
}
