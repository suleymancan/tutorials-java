package _03attribute.request.dispatch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _03attribute.request.dispatch.model.Person;

@WebServlet("/person")
public class PersonController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// istek buraya gelecek. Burası PersonController.
		// isteği karşıladıktan sonra basit bir jsp dosyasından da faydalanacağım.

		// mantik: controller servis katmanina erisecek, servis katmani dao katmanina
		// erişecek.
		// dao'dan verimiz geldikten sonra biz direkt olarak geriye jsp dosyasina
		// attribute döneriz.
		// controller seviyesinde direkt veritabani baglantisi yapilmaz,dao katmanında
		// yapılır.
		// controller->service layer->dao'ya.
		// datayı manuel olarak elle ekliyorum.

		Person person1 = new Person("Suleyman", "Can");
		Person person2 = new Person("Nazlisu", "Can");
		Person person3 = new Person("Mehmet Ali", "Can");
		Person person4 = new Person("Kiymet", "Can");
		Person person5 = new Person("Haci", "Can");

		// datayı alıp jsp dosyasına dispach edeceğiz.

		List<Person> personList = new ArrayList<Person>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);
		// bu datanın veritabanından geldiğini düşünüyorum.
		// tablo formatında yazsam burada java içine html gömücem ama bunu jsp tarafında
		// yapacağım.

		// request scope'a objeyi ekledim.
		// obje eklendikten sonra jsp dosyasından ilgili attribute ulaşabilirim.
		// böylece request attribute kullanmış oldum.

		req.setAttribute("persons", personList);

		// bir istek geldiğinde hem servlet hem jsp dosyası kullanılacak.
		// istek karşılanırken hem servlet hem jsp kullanılıyor ve bu tek bir istek
		// oluyor.
		// RequetDispatch...

		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/personView.jsp");
		dispatcher.forward(req, resp); // request ve response objesini kullanı anlamına geliyor.

	}
}
