package _03attribute;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contextAttributeDeneme")
public class ContextAttributeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context=getServletContext();
		//context.setAttribute("key","value"); //name,object
		context.setAttribute("contextAtributeKey","contextAttributeValue");
	}
}
