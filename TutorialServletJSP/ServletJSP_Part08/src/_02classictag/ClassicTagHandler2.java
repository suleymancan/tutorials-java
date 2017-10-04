package _02classictag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ClassicTagHandler2 extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

		JspWriter writer = pageContext.getOut();
		try {
			writer.println("ClassicTagHandler2#doStartTag");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY; // 0'a denk geliyor. ve body dolaşımını atla demek oluyor.
	}

	@Override
	public int doEndTag() throws JspException {

		JspWriter writer = pageContext.getOut();
		try {
			writer.println();
			writer.println("doEndTagMethod");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE; //
	}
	// doEndTag metodunun donus tipi SKIP_PAGE ise bu durumda sayfanin geri kalani
	// degerlendirmeye alinmaz.
	// Simple Tag yapisindaki SkipPageException ile aynidir.
	// EVAL_PAGE donus tipi oldugunda sayfanin geri kalani calisir/degerlendirmeye
	// alinir.
}
