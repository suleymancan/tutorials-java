package _03captchacontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String captchaCode = req.getParameter("captchaCode");

		// session'a ekledigim captcha code çekecegim.

		HttpSession session = req.getSession();
		Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		// captcha dogru mu
		boolean isCorrect = captcha.isCorrect(captchaCode);

		if ("vayorebl".equals(username) && "2327".equals(password) && isCorrect) {
			session.setAttribute("username", username);
			resp.sendRedirect("welcome.jsp");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			if (!isCorrect) {
				req.setAttribute("errorMessage", "capcha hatali!");
			} else {
				req.setAttribute("errorMessage", "Kullanici adi ya da parola hatali!");
			}
			dispatcher.forward(req, resp);

		}

	}
}
