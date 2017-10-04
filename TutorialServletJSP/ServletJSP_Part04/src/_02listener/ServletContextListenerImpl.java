package _02listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//web.xml yaklaşımı: <listener> <listener-class>packageadi.classadi</listener-class> </listener>

//annotation yaklaşımı:
@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// ServletContext objesi oluştuğunda çalışır.
		System.out.println("contextInitialized###");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed###");

	}

}
