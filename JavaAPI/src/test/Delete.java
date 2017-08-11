package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.io.*;
import org.json.simple.*;
import java.util.*;

@Path("/delete")
public class Delete {
@GET
public void deleteFromDB(@QueryParam("arr") String array) throws Exception
  {
	      

  System.out.println(array);
  
  StringTokenizer st = new StringTokenizer(array,"\"![],?._'@");
  PreparedStatement ps=null;
   
Connection connection = DriverManager.getConnection(
	"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
	"admin");
  while (st.hasMoreTokens()) 
  { 
	   String name=st.nextToken();
	 // System.out.println(st.nextToken()); 
	  
ps=connection.prepareStatement("delete from employee where name=?");  
ps.setString(1, name);
ps.executeUpdate(); 
  }
  
  }




}