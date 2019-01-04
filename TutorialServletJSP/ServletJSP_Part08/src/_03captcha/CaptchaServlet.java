package _03captcha;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.servlet.StickyCaptchaServlet;


//jpg olmak zorunda degil.
@WebServlet("/simpleCaptcha.jpg")
public class CaptchaServlet extends StickyCaptchaServlet  {
	
	//image'lar get istegiyle cekilir. 
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	HttpSession session=req.getSession();
	
	//renk verme.
	GradiatedBackgroundProducer bg=new GradiatedBackgroundProducer();
	bg.setFromColor(Color.red);
	bg.setToColor(Color.white);
	
	//boyut ve arka plana çizgi ekleme
	Captcha captcha=new Captcha.Builder(200, 50).addText().addNoise().addBackground(bg).build();
	
	//captcha'nın özel ismi var. Browser'da ilgili session için captcha çıkacak.
	session.setAttribute(Captcha.NAME, captcha);
	
	//captcha olusturma.
	CaptchaServletUtil.writeImage(resp, captcha.getImage());
	}
}
