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
    
    @Path("/{examKey}")
    @GET
    @Produces("application/json")
    public Exam getFromKey(@PathParam("examKey") int examKey){
    	return examdb.getFromKey(examKey);
    }
    
    @Path("")
    @POST
    public Response insertExam(Exam exam){

        if (examdb.insert(exam)) {
        	return Response.status(201).build();
        }
        
        return Response.status(500).build();
    }
    
    @Path("/{examKey}")
    @DELETE
    public Response deleteExam(@PathParam("examKey") int examKey){

        if (examdb.delete(examKey)) {
        	return Response.status(200).build();
        }
        
        return Response.status(500).build();
    }
    
    @Path("/{examKey}")
    @PUT
    public Response updateExam(@PathParam("examKey") int examKey, Exam modifiedExam) {
    	
    	if (examdb.updateDescription(examKey, modifiedExam)) {
    		return Response.status(200).build();
    	}
    	
    	return Response.status(500).build();
    	
    }
    
    @Path("/search/{search}")
    @GET
    @Produces("application/json")
    public ArrayList<Exam> searchDescription(@PathParam("search") String search, @QueryParam("partial") boolean partialSearch){
    	
    	if (partialSearch == true) {
    		return examdb.partialSearch(search);
    	}
    	return examdb.exactSearch(search);
    }
		
	
}













