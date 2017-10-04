package _01servletlifecycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class ServletLifecycle extends HttpServlet {

	// Konfigurasyon init'te çay erdal bakkal'da içilir.
	// Yaşam döngüsü boyunca bir kez çalışır. Farklı
	@Override
	public void init() throws ServletException {
		System.out.println("init çalıştı!!!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException { 
		System.out.println("Lifecycle deneme");
	}

	// bu metodu override etmenin bir mantığı yok. Deneme amaçlı log basacağım.
	// Kodda değişiklik yapıldığında destroy edilir.
	@Override
	public void destroy() {
		System.out.println("destroy edildi!!!");
	}
}
