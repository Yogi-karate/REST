package test;
import java.io.IOException;
import java.io.StringWriter;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;
import org.json.simple.JSONObject;
import java.sql.*;

	@Path("/hello")
	 public class Fetch {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<JSONObject> returnData() throws IOException,SQLException
	{
  ArrayList<JSONObject> ar= new  ArrayList<JSONObject>();
	      
  Connection connection = DriverManager.getConnection(
			"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
			"admin");
PreparedStatement ps=connection.prepareStatement("select * from employee");  
ResultSet rs=ps.executeQuery();  
while(rs.next())
{
	JSONObject obj = new JSONObject();
	obj.put("name",rs.getString(1));
	obj.put("role",rs.getString(2));
ar.add(obj);
obj=null;
}
	      return ar;
	}

	

	}
