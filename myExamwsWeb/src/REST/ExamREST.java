package REST;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import DB.ExamDB;
import entities.Exam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import java.util.ArrayList;

import javax.ws.rs.DELETE;



@Path("/exam")
public class ExamREST{
	
	private ExamDB examdb = new ExamDB();
	
    @Path("")
    @GET
    @Produces("application/json")
    public ArrayList<Exam> getAllContents(){
        return examdb.getAll();
    }
		
	
}













