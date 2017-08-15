package test;

import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.*;

@Path("/update")
public class Update {
@GET
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public void updateTable(@QueryParam("name") String name,@QueryParam("role") String role,@QueryParam("key") String key) throws Exception
  {
		      
  Connection connection = DriverManager.getConnection(
			"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
			"admin");
  PreparedStatement ps=null;
	   String[] names=jsonStringToArray(name);
	   String[] roles=jsonStringToArray(role);
	   String[] keys=jsonStringToArray(key);
	   for(int i=0;i<names.length;i++)
	   {
 ps=connection.prepareStatement("update employee set name=?,role=? where name=?");  
ps.setString(1,names[i]);
ps.setString(2,roles[i]);
ps.setString(3,keys[i]);
ps.executeUpdate();  
//System.out.println(name+" "+role+" "+key);
  }
	 //  return "records updates"+names.length;
  }

public static String[] jsonStringToArray(String jsonString) throws Exception {

	  StringTokenizer st = new StringTokenizer(jsonString,"\"![],?._'@");
	  ArrayList<String> ar= new ArrayList<String>();
	  while (st.hasMoreTokens()) 
	  { 
		   String token=st.nextToken();
		   ar.add(token);
	  }
	  String[] arr = new String[ar.size()];
	  arr = ar.toArray(arr);
  

   
    return arr;
}

}

