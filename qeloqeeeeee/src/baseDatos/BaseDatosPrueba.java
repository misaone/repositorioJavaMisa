package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class BaseDatosPrueba {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PruebaMySQL mio = new PruebaMySQL();
			mio.insertlib();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		

	}
	
	
	
	

}
