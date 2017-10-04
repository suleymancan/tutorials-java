package _01simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagHandler extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {

		getJspContext().getOut().print("Hello Simple Tag Example!");
	}
	/*
	 * SimpleTagHandler Lifecycle: Container ilgili class dosyasını yükler ve bu
	 * class'tan yeni bir obje oluşur. setJspContext metodu çalışır. Eğer nested tag
	 * yapısı varsa setParent metodu çalışır. Attribute varsa attribute ait setter
	 * metodu çalışır. Eğer body boş değilse, (<body-content> empty değilse )
	 * setJSPBody çalışır. son olarak doTag çalışır.
	 */
}
