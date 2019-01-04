package _03attribute;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getContextAttributeServlet")
public class GetContextAttributeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	ServletContext context=getServletContext();
	String attribute=(String) context.getAttribute("contextAtributeKey");
	System.out.println("Context scope attribute: "+attribute);
	}
}
