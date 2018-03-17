/**
* 
*/
package interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author suleymancan Mar 16, 2018
 */
public class AuditInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger("auditLogger");
	private String user;
	private String productId;

	// Istek gelmeden önce calisir.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler) throws Exception {

		System.out.println("preHandle");

		if (request.getRequestURI().endsWith("add")) {

			if (request.getMethod().equals("GET")) {
				//
				logger.info("preHandle : GET request");
			}

			if (request.getMethod().equals("POST")) {
				user = request.getRemoteHost();
				productId = request.getParameter("productId");
				//
				logger.info("preHandle : POST request");
			}
		}
		return true;
	}

	// istek tamamlandıktan sonra calisir.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception arg3) throws Exception {

		System.out.println("afterCompletion");
		// urun ekledikten sonra redirect islemi sonrasinda HTTP 302 POST
		// request olusur.
		if (request.getRequestURI().endsWith("add") && response.getStatus() == 302) {
			logger.info(String.format("A New product[%s] Added by %s on %s", productId, user, getCurrentTime()));
		}
	}

	// Istek karsilandıktan sonra calisir.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("postHandle");

		if (request.getRequestURI().endsWith("add")) {

			if (request.getMethod().equals("GET")) {
				//
				logger.info("postHandle : GET request");
			}

			if (request.getMethod().equals("POST")) {
				logger.info("postHandle : POST request");
			}
		}

	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
