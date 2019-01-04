package _02classictag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// classic tag için TagSupport class'ını kalıtıp, doStartTag metodunu override ettim. 
public class ClassicTagHandler extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

		JspWriter writer = pageContext.getOut();
		try {
			writer.print("hello classic tag!#doStartTag");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY; // 0'a denk geliyor. ve body dolaşımını atla demek oluyor.
	}
	// doStartTag metodu donus tipi SKIP_BODY oldugunda body degerlendirmeye alinmaz
	// direkt olarak doEndTag metoduna gecer. Eger donus tipi EVAL_BODY_INCLUDE
	// ise bu durumda body calisir ve doAfterBody calisir.

}
