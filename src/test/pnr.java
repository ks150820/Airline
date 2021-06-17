package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pnr {
public void checkPNR(String pnrnumber,String firstname,String fromCity,String status,String toCity) throws SQLException, ClassNotFoundException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kapil");
	
	PreparedStatement stmt=Con.prepareStatement("insert into PNR values(?,?,?,?,?)");
	stmt.setString(1, pnrnumber);
	stmt.setString(2, firstname);
	stmt.setString(3, fromCity);
	stmt.setString(4, toCity);
	stmt.setString(5, status);
	
	int i=stmt.executeUpdate();  
	System.out.println(i+" records inserted"); 
	
	
}
}
