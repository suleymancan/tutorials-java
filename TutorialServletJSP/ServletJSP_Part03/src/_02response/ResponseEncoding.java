package _02response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RespEncodingDeneme")
public class ResponseEncoding extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		// req.setCharacterEncoding("UTF-8"); bu yazıyla alakalı bir kullanım değil.
		// açıklama req.getCharacterEncoding satırında.

		 resp.setCharacterEncoding("UTF-8"); //bu metot kural olarak ekrana yazı
		// basmadan önce verilmeli!
		// UTF-8 en temizi. ISO-8859-9 ile de Türkçe karakter sorununu çözebiliriz fakat
		// UTF-8 bir Unicode dönüşüm biçimidir. UTF-8 kullanımı daha mantıklı.

		// resp.setContentType("text/html; charset=UTF-8"); //bir üstle aynı işi yapar.

		PrintWriter pw = resp.getWriter();
		pw.print("<html><body>");

		pw.print("<head> <meta charset='UTF-8'> </head> "); // iki ucu aynı yaptım.
		// böylece tarayıcı kaynaklı karakter sorunlarının önüne geçtim. artık her
		// tarayıcıda
		// benim verdiğim charset geçerli.

		pw.print("ıİşŞçÇöÖÜü" + "<br>"); // bu çıktı eclipse tarayıcıda ilk olarak ????çÇöÖÜü böyle göründü.
		// en üstte UTF-8 verdikten sonra (meta charset vermeden) yazı hepten bozuldu.
		// "Ä±Ä°ÅŸÅžÃ§Ã‡Ã¶Ã–ÃœÃ¼" Çünkü iki uç farklı oldu
		// bu problemi bi üst satırda meta-set verip giderdim. çıktı aynen "ıİşŞçÇöÖÜü" oldu.

		// String reqEncoding=req.getCharacterEncoding(); bu yazıyla alakası yok. deneme
		// amaçlı kullandım.
		// ilk başta null verdi. req.setCharacterEncoding verince UTF-8 verdi.
		// Varsayılan null!

		String respEncoding = resp.getCharacterEncoding();

		// pw.print("reqEncoding: "+reqEncoding+"<br>"); //varsayılan Null

		pw.print("respEncoding: " + respEncoding + "<br>"); // varsayılan ISO-8859-1 setCharterEncoding'den sonra UTF-8
		pw.print("</body></html>");
	}
}
