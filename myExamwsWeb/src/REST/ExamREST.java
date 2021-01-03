package REST;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import DB.ClientDB;
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
	private ClientDB clientdb = new ClientDB();
	
	
    @Path("")
    @POST
    public Response insertExam(Exam exam){

        if (examdb.insertExam(exam)) {
        	return Response.status(201).build();
        }
        
        return Response.status(500).build();
    }
	
    @Path("")
    @GET
    @Produces("application/json")
    public ArrayList<Exam> getAllExams(){
        return examdb.getAllExams();
    }
    
    @Path("/{examKey}")
    @GET
    @Produces("application/json")
    public Exam getFromKey(@PathParam("examKey") int examKey){
    	return examdb.getExamFromKey(examKey);
    }
    
    
    @Path("/{examKey}")
    @DELETE
    public Response deleteExam(@PathParam("examKey") int examKey){
    	
    	if(!clientdb.hasExamGrades(examKey)) {
    		return Response.status(401).build();
    	}

        if (examdb.deleteExam(examKey)) {
        	return Response.status(200).build();
        }
        
        return Response.status(500).build();
    }
		
	
}













