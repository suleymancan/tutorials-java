package _03function;

public class ExpressionFunction {
	
	//metot public static olmalı.
	//tld dosyası tanımlayacağım. (tld:tag library descriptor
	//bu tld web-inf altında olmalı. buraya function'umu tanımlayacağım.
	//myFuction.tld -> otomatik olarak taranır
	//xml tanımlama kodunu http://docs.oracle.com/javaee/1.4/tutorial/doc/JSPTags6.html
	//adresinden kopyaladım. 
	public static int calculate(int number1, int number2)
	{
		return number1+number2;
	}
}
