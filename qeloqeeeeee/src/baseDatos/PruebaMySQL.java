package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaMySQL {

	public PruebaMySQL() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;
            
            con = null;
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?&user=root&password=cERVATIYO99"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
            
            Statement stmt = con.createStatement();
        	ResultSet rs = stmt.executeQuery(
         		"SELECT titulo, precio FROM Libros WHERE precio > 2");
        		
        	while (rs.next()) {
        		String name = rs.getString("titulo");
        		float price = rs.getFloat("precio");
        		System.out.println(name + "\t" + price);
        	}
        	rs.close();
        	stmt.close();		
        	con.close();

       } catch (Exception e) {
    	   e.printStackTrace();
       }
	}
	
	public static void insertlib() {
		
		Connection con;
    
		//con = null;
	try {
      
        
        con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?&user=root&password=cERVATIYO99"
                + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
        
       PreparedStatement ps;
       
       ps = con.prepareStatement("INSERT INTO Libros VALUES (?,?,?)");
     //  ps = con.prepareStatement("UPDATE libros SET precio=86, titulo=?, WHERE idLibro=?");
       
       
       ps = con.prepareStatement("UPDATE libros SET precio=86 WHERE idLibro=?");
       
       ps.setInt(1, 23);
      //ps.setString(2, "ddfdf");
      //ps.setInt(3, 45);
       
       ps.executeUpdate();
       con.close();
       
       
   } catch (SQLException ex) {
       Logger.getLogger(PruebaMySQL.class.getName()).log(Level.SEVERE, null, ex);
       
   }
}

}
