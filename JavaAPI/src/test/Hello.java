package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.sql.*;
import java.io.*;
import org.json.simple.*;
import java.util.*;

@Path("/hell")
public class Hello {
@POST
public String addEvent(String jsonBody) throws Exception {
    System.out.println(jsonBody);
    return "hi";
  }

}


