package _03responseheader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseHeaderDeneme")
public class ResponseHeader extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		// resp.addHeader(name, value); //String name, String value
		resp.addHeader("takim", "Gaziantepsporum"); // ekler
		resp.setHeader("takim", "Her zaman Gaziantepspor"); // override eder
		resp.addHeader("takim", "Gaziantepspor");
		// çalıştırıp tarayıcının network kısmından response header kısmında eklendigini
		// görebiliriz.

		pw.print("<html><body>");
		// containsHeader metodu parametre olarak aldigi degerde response header olup
		// olmadigini kontrol eder.
		// Eger ilgili response header varsa true yoksa false donecektir.
		boolean contains = resp.containsHeader("firstName");
		pw.print("contains (firstName):" + contains + "<br>");
		boolean contains2 = resp.containsHeader("takim");
		pw.print("contains2 (takim):" + contains2 + "<br>");

		// headerlara ulaşayım.
		String tekliHeaderUlasimTakim = resp.getHeader("takim");
		pw.println("tekliHeaderUlasimTakim: " + tekliHeaderUlasimTakim + "<br>"); // ilk eklenen header bilgisinin set
																					// edilmiş halini basar.
		// takim adinda iki header bilgisi bulunmakta fakat böyle ilk eklenen headerı
		// çekebildim.

		int i = 1;
		// aynı name sahip diger header bilgilerini çekmek için:
		Collection<String> takimsHeader = resp.getHeaders("takim");
		for (String takimHeaderları : takimsHeader) {
			pw.print(i + "-takim adi: " + takimHeaderları + "<br>");
			i++;
		}

		// setIntHeader ve addIntHeader da value parametresi int tipindedir.
		// setDateHeader ve addDateHeader value kismi long tipindedir.
		resp.addIntHeader("yil", 1969);
		resp.addDateHeader("bugun", System.currentTimeMillis()); // sistem saat tarih

		String yil = resp.getHeader("yıl");
		pw.println("yil: " + yil + "<br>");

		String bugun = resp.getHeader("bugun");
		pw.println("bugun: " + bugun + "<br>");
		int a = 1;
		// getHeaderNames metodu bize response header'larin ismini donecektir.
		Collection<String> headerNames = resp.getHeaderNames();
		for (String headerName : headerNames) {
			pw.print(a + "-headerName: " + headerName + "<br>");
			a++;

		}

		pw.print("</body></html>");
	}

}
