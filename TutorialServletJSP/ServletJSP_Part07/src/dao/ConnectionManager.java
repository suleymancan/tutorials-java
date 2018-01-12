package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

//src/db.properties dosyasında key value şeklinde data yer alır.
//bunları ayırmak için araya = konur.
//bu properties dosyasını veritabanı bilgilerim için ben oluşturdum.
//jdbc'de tabloyu manuel olarak elle oluşturuyorum. orm'de otomatik oluşuyormuş.
public class ConnectionManager {
	//DataSource connectionları yönetir. DataSource üzerinden connectionları elde edeceğim.
	public DataSource getMySQLDataSource() {
		Properties props= new Properties();
		//dataları okuyacağım.
		//db.properties dosyam src altında yer alıyor. (classpath'de.)
		//classloader yardımıyla okuyacağım.
		//her class'ı getClass şeklinde çağırabilirim. 
		InputStream is=getClass().getClassLoader().getResourceAsStream("db.properties");
		//okuyacağımız datalar yardımıyla mysqldatasource oluşturabiliyoruz.
		//farklı şekillerde de veritabanına bağlanmak mümkündür.
		mySQLDataSource mySQLDataSource=null;
		
		try {
			props.load(is);
			mySQLDataSource =new MysqlDataSource();
			//set ediyorum.
			mySQLDataSource.setURL(props.getProperty("url"));
			mySQLDataSource.setUser(props.getProperty("username"));
			mySQLDataSource.setPassword(props.getProperty("password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   //geri dönüyorum.
		return mySQLDataSource;
		
	}
}
