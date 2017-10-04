package _05responsedownload;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExcelDownload")
public class ExcelDownload extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// bunlar gerekli tanımlamalar.
		resp.setContentType("application/ms-excel");
		resp.setHeader("Content-Disposition", "attachment; filename=test.xlsx");

		ServletContext context = getServletContext();
		// getResourceAsStream metodu ile projemizdeki static kaynaklara ulasabiliriz.
		// dinamik kaynaklar için jasperReports, apache poi filan deneyeceğim.
		InputStream is = context.getResourceAsStream("deneme.xlsx");
		// bu bi yaklaşım. başka türlü de yapılabilir.
		int r = 0;
		byte[] bytes = new byte[1000];
		ServletOutputStream sos = resp.getOutputStream(); // getWriter kullanirsan illegal hatasi alirsin. ikisi ayni
															// anda yazilmaz.
		while ((r = is.read(bytes)) != -1) {
			sos.write(bytes);
		}
		sos.close();
	}
}
