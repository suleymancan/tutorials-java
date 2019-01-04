package _01request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestMethodsDeneme")
public class RequestMethods extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		// valla metot yardırıcam. req.get... ne varsa deneyeceğim.
		Locale lokal = req.getLocale();
		String lokalName = req.getLocalName();
		String servletPath = req.getServletPath();
		int servletPort = req.getServerPort();
		String serverName = req.getServerName();
		String getScheme = req.getScheme();
		String requestURI = req.getRequestURI();
		int remotePort = req.getRemotePort(); // client/tarayici
		String remoteHost = req.getRemoteHost();
		String remoteAddr = req.getRemoteAddr();
		String protocol = req.getProtocol();
		int localPort = req.getLocalPort();
		String localAddr = req.getLocalAddr();
		String hostname = req.getHeader("host");

		// server port requestin ilk karsilandigi basladigi porttur. local port ise bu
		// istegin tamamlandigi porttur.

		pw.print("lokal: " + lokal + "<br>");
		pw.print("lokalName: " + lokalName + "<br>");
		pw.print("servletPath: " + servletPath + "<br>");
		pw.print("servletPort: " + servletPort + "<br>");
		pw.print("serverName:" + serverName + "<br>");
		pw.print("getScheme: " + getScheme + "<br>");
		pw.print("requestURI:" + requestURI + "<br>");
		pw.print("remotePort: " + remotePort + "<br>");
		pw.print("remoteHost: " + remoteHost + "<br>");
		pw.print("remoteAddr: " + remoteAddr + "<br>");
		pw.print("protocol:" + protocol + "<br>");
		pw.print("localPort: " + localPort + "<br>");
		pw.print("localAddr: " + localAddr + "<br>");
		pw.print("hostname: " + hostname + "<br>");

		// headerları döşüyeyim. Header'lar server ile client arasindaki küçük bilgiler.
		// Header bilgileri ile sitelerde download yönlendirmeleri vs. yapilabilir.
		// Windows ile giris yaptiysan windows sürümüne yönlendirir.

		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String hname = headerNames.nextElement();
			String hValue = req.getHeader(hname);
			System.out.println("headerNames: " + hname);
			System.out.println("headerValue: " + hValue);
		}

	}
}
