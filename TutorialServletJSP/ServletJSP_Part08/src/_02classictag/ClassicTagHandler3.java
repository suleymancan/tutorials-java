	package _02classictag;
	
	import java.io.IOException;
	
	import javax.servlet.jsp.JspException;
	import javax.servlet.jsp.JspWriter;
	import javax.servlet.jsp.tagext.TagSupport;
	
	public class ClassicTagHandler3 extends TagSupport {
	
		@Override
		public int doStartTag() throws JspException {
	
			JspWriter writer = pageContext.getOut();
			try {
				writer.print("ClassicTagHandler3#doStartTag");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			return EVAL_BODY_INCLUDE; // bu kısımdan sonra jsp body çalisacak.
		}
	
		@Override
		public int doEndTag() throws JspException {
	
			JspWriter writer = pageContext.getOut();
			try {
				writer.print("doEndTagMethod");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return EVAL_PAGE; //
		}
	
	}
