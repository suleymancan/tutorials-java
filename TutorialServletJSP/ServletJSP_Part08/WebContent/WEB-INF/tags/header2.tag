<%@ tag language="java" pageEncoding="utf-8"%>
<%@ attribute name="tittle" required="true" rtexprvalue="true" %>

<%--reuqired bu attribute gerekli mi demek. false ise gerek yok.
rtexprvalue: expression value alabilir mi alamaz mı --%>
<h4>headertag2</h4>
<h1>tittle: ${tittle}</h1>
