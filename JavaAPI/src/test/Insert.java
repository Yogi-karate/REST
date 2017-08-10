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
public void insertIntoDB(@QueryParam("name") String name,@QueryParam("role") String role) throws Exception
  {
  	      
  Connection connection = DriverManager.getConnection(
			"jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
			"admin");
PreparedStatement ps=connection.prepareStatement("insert into employee(name,role) values('" +name+ "','"+role+"')");  
ps.executeUpdate();

  }



}


