package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_update {

			public static void main(String[] args) throws SQLException {
				Connection con=null;
				try {
				Driver driver=new Driver();
				
				//step 1:register the database or drive
				DriverManager.registerDriver(driver);
				
				//step 2:get the connection to database
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3307/deoxy","root","root");
		
		//step 3: issue the create statement
		Statement s= con.createStatement();
		
		//step 4: execute update
		String query="insert into kittu values('srilax',67,'kphp'";
		   int res= s.executeUpdate(query);
		      if(res>=1)
		      {
		    	  System.out.println("data add");
		      }
		      
		      // step 5: execute query
		  ResultSet result= s.executeQuery("select * from kittu;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}}
		catch (Exception e) {
			// TODO: handle exception
		}
		//close the database
				finally {
					con.close();
					System.out.println("db closed");
			}

		}
}

	


