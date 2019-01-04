package _05fileupload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/file.upload")
public class FileUploadServlet extends HttpServlet {
	// dosyanin kaydedilecegi yol. bu bir server da olabilir.
	private final String UPLOAD_DIRECTORY = "C:\\Users\\SULEYMANCAN\\Desktop";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// if kontrolüServletFileUpload ile gelen HttpServletRequest nesnesinin
		// multipart(cok parcali) olup olmadığı kontrol ediyor.
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				// DiskFileItemFactory, içeriklerini bellekte, küçük öğeler için veya diskte
				// geçici bir
				// dosyada tutan dosya öğeleri örnekleri oluşturur. hangi içeriğin diskte
				// saklanacağı, boyutu, geçici dosyaların oluşturulacağı dizinde olduğu gibi
				// yapılandırılabilir.
				// https://commons.apache.org/proper/commons-fileupload/apidocs/org/apache/commons/fileupload/disk/DiskFileItemFactory.html

				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload fileUpload = new ServletFileUpload(factory);
				List<FileItem> multiparts = fileUpload.parseRequest(request);
				for (FileItem item : multiparts) {
					// isFormField, bir fileitem örneğinin basit bir form alanını temsil edip
					// etmediğini belirler.
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

					}
				}
				request.setAttribute("message", "Basarili!");
			} catch (Exception ex) {
				request.setAttribute("message", "Dosya su nedenle yuklenmedi: " + ex);
			}

		} else {
			request.setAttribute("message", "Bu servlet sadece yukleme islemi yapmaktadir");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
	}
}