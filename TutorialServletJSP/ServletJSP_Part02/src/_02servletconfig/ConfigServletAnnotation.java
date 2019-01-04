package _02servletconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/configanodeneme",initParams=@WebInitParam(name="ano",value="annotation"))
public class ConfigServletAnnotation extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {

	//degisik bir deneme.
	String anoDeneme=getServletConfig().getInitParameter("ano");
	resp.getWriter().println(anoDeneme);

}
}
