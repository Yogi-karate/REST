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

@Path("/hell")
public class Insert {
@GET
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public JSONObject insertIntoDB(@QueryParam("name") String name,@QueryParam("role") String role) throws IOException
  {
	//JSONObject obj = new JSONObject();
	try {
  Connection connection = DriverManager.getConnection(
			"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
			"admin");
PreparedStatement ps=connection.prepareStatement("insert into employee values(?,?)");
JSONObject obj=new JSONObject();
ps.setString(1,name);
ps.setString(2,role);
ps.executeUpdate();
obj.put("name", name);
obj.put("role", role);
System.out.println(obj);
//JSONObject obj=sample(ps,name,role);
 return obj;
  }
	
	
catch(SQLException e)
	{
	//System.out.println(e);
	JSONObject obj1 = new JSONObject();
	obj1.put("name",name+" who already exist, sorry no duplicate names allowed");
	System.out.println(obj1);
	return obj1;
	}
	//return obj;
	}

  }




