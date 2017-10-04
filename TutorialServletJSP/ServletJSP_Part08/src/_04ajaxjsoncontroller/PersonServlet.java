package _04ajaxjsoncontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import _04ajaxjsonmodel.Person;
import _04ajaxjsonmodel.Result;

@WebServlet("/person.servlet")
public class PersonServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//data json formatında geliyor bunu servlet karşılamalı. gelen istegi satır satır okuyacağım.
		
		BufferedReader br=new BufferedReader(new InputStreamReader(req.getInputStream())); 
		//çok fazla string işlemi varsa StringBuffer kullanılabilir.
		StringBuffer jsonData=new StringBuffer();
		String line="";
	
		while((line=br.readLine())!=null) {
			jsonData.append(line); //datayı aldık.
		}
		Gson gson=new Gson();
		Person person=gson.fromJson(jsonData.toString(),Person.class);
		
		//dönen datayı yazdıralım.
		System.out.println(person);
		
		Result result = new Result();
		result.setMessage("Basarili!");
		result.setReturnCode("200");
		
		
		//geriye json dönme	
		String resultJSON = gson.toJson(result);
		System.out.println(resultJSON);
		//
		
		PrintWriter pw = resp.getWriter();
		pw.write(resultJSON);
		pw.close();
	}
}
