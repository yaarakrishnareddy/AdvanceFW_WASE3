package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class JDBC_CONN {

	public static void main(String[] args) throws SQLException {
		//driver for mysql
Driver driver=new Driver();
//register to database/driver
DriverManager.registerDriver(driver);
//get connection to database
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3307/deoxy", "root", "root");
// issue created statment
Statement st=con.createStatement();
//executeQuery
ResultSet rs=st.executeQuery("select * from kittu;");
while(rs.next())
{
	System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));
}
//close the database
con.close();
System.out.println("database close");


	}

}
