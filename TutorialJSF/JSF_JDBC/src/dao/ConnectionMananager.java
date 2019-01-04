package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionMananager {

	// singleton dizayn patern

	private static final ConnectionMananager INSTANCE = new ConnectionMananager();

	private ConnectionMananager() {

	}

	public static ConnectionMananager getInstance() {
		return INSTANCE;
	}

	public DataSource getMySQLDataSource() {
		Properties props = new Properties();
		InputStream is = null;
		MysqlDataSource mysqlDataSource = null;
		is = this.getClass().getClassLoader().getResourceAsStream("db.properties");

		try {
			props.load(is);
			mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setURL(props.getProperty("url"));
			mysqlDataSource.setUser(props.getProperty("username"));
			mysqlDataSource.setPassword(props.getProperty("password"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDataSource;
	}
}
