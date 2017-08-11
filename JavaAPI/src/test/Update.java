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

@Path("/update")
public class Update {
@GET
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public void insertIntoDB(@QueryParam("name") String name,@QueryParam("role") String role) throws IOException,SQLException
  {
  Connection connection = DriverManager.getConnection(
			"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
			"admin");
  String[] names = toStringArray(name);
  String[] roles= toStringArray(role);
  for(int i=0;i<names.length;i++)
  {
     
PreparedStatement ps=connection.prepareStatement("update employee set name=? and role=? where name=?)");
ps.setString(1,name);
ps.setString(2,role);
ps.setString(3,name);
ps.executeUpdate();
 

	}
  }
public static String[] toStringArray(String str)
{
	ArrayList<String> ar=new ArrayList<String>();
	 StringTokenizer st = new StringTokenizer(str,"\"![],?._'@");
	 while(st.hasMoreTokens())
	 {
		 ar.add(st.nextToken());
	 }
String[] arr=new String[ar.size()];
 arr = ar.toArray(arr);
	
	return arr;
  }
}
