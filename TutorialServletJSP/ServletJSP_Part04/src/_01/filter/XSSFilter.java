package _01.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*->bütün url'ler için çalis." "/login/*-> loginden sonra herseyde çalis."*.html->html ile biten url'de çalis.")
@WebFilter("/*") //bütün url'de çalış. Her istek geldiğinde çalış.
public class XSSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("XSS Filter çalıştı.");
		chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request),response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
