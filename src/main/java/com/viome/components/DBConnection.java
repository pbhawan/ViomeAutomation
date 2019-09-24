package com.viome.components;

import java.sql.Statement;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class DBConnection {
	
		  //Redshift driver: "jdbc:redshift://x.y.us-west-2.redshift.amazonaws.com:5439/dev";
	    static final String dbURL = "jdbc:redshift://viome-metacube-cluster.cmcvkrhcw0ac.us-east-2.redshift.amazonaws.com:5439/viomedev";
	    static final String MasterUsername = "viome";
	    static final String MasterUserPassword = "METAViomecube3";

	    public static void main(String[] args) {
	        Connection conn = null;
	        Statement stmt = null;
	        try{
	           //Dynamically load driver at runtime.
	           //Redshift JDBC 4.1 driver: com.amazon.redshift.jdbc41.Driver
	           //Redshift JDBC 4 driver: com.amazon.redshift.jdbc4.Driver
	           Class.forName("com.amazon.redshift.jdbc.Driver");

	           //Open a connection and define properties.
	           System.out.println("Connecting to database...");
	           Properties props = new Properties();

	           //Uncomment the following line if using a keystore.
	           //props.setProperty("ssl", "true");
	           props.setProperty("user", MasterUsername);
	           props.setProperty("password", MasterUserPassword);
	           conn = DriverManager.getConnection(dbURL, props);

	           //Try a simple query.
	           System.out.println("Listing system tables...");
	           stmt = conn.createStatement();
	           String sql;
	           sql = "SELECT * FROM public.location;";
	           ResultSet rs = stmt.executeQuery(sql);

	           //Get the data from the result set.
	           while(rs.next()){
	              //Retrieve two columns.
	              String created_by = rs.getString("created_by");
	              String address = rs.getString("address1");

	              //Display values.
	              System.out.print("created_by: " + created_by);
	              System.out.println(", Name: " + address);
	           }
	           rs.close();
	           stmt.close();
	           conn.close();
	        }catch(Exception ex){
	           //For convenience, handle all errors here.
	           ex.printStackTrace();
	        }finally{
	           //Finally block to close resources.
	           try{
	              if(stmt!=null)
	                 stmt.close();
	           }catch(Exception ex){
	           }// nothing we can do
	           try{
	              if(conn!=null)
	                 conn.close();
	           }catch(Exception ex){
	              ex.printStackTrace();
	           }
	        }
	        System.out.println("Finished connectivity test.");
	     }
		
	}
	


