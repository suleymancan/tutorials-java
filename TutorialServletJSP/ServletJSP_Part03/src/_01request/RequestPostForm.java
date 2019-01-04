package _01request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestPostDeneme")
public class RequestPostForm extends HttpServlet {

	//doGet ile deneyeceksen burayı doGet olarak değiştir.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		String name = req.getParameter("Name");
		String gender = req.getParameter("gender");
		String stadium = req.getParameter("gaziantep sports");
		// comboboxta birden fazla seçim olasılığı olduğundan diziye ihtiyaç var.
		String[] takimlar = req.getParameterValues("takim");

		pw.println("Nick: " + name + "<br>");
		pw.println("Cinsiyeti: " + gender + "<br>");
		pw.println("Istedigi stadyum ismi: " + stadium + "<br>");
		pw.println("Destekledigi: " + Arrays.asList(takimlar) + "<br>");

		pw.println("-----------------------<br>");
		// formda girilen bilgileri bir de map ile ekrana dökelim. form dosyasındaki
		// name ve ilgili value kısmını dökecek
		Map<String, String[]> parameterMap = req.getParameterMap();
		for (Map.Entry<String, String[]> en : parameterMap.entrySet()) {
			pw.print(en.getKey() + " " + Arrays.asList(en.getValue()) + "<br>");
		}
	}

}
