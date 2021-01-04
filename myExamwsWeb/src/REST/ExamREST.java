package REST;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import DB.ClientDB;
import DB.ExamDB;
import DB.ServerDB;
import entities.Client;
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
    @POST
    public Response insertExam(Exam exam){
    	
    	if(examdb.hasServer(exam.getLocation()) || examdb.hasExamWithLocation(exam.getLocation())) {
    		return Response.status(409).build();
    	}

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
    
    @Path("/fullDescription/{description}")
    @GET
    @Produces("application/json")
    public ArrayList<Exam> fullSearchDescriptio(@PathParam("description") String description){
    	return examdb.fullSearchDescription(description);
    }
    
    @Path("/partialDescription/{description}")
    @GET
    @Produces("application/json")
    public ArrayList<Exam> partialSearchDescription(@PathParam("description") String description){
    	return examdb.partialSearchDescription(description);
    }
    
    @Path("/{examKey}")
    @DELETE
    public Response deleteExam(@PathParam("examKey") int examKey){
    	
    	if(examdb.hasExamGrades(examKey)) {
    		return Response.status(409).build();
    	}

        if (examdb.deleteExam(examKey)) {
        	return Response.status(200).build();
        }
        
        return Response.status(500).build();
    }
    
    @Path("/{key}")
    @PUT
    public Response modifyExamDescription(@PathParam("key")  int key, Exam exam){
    		
    	if(!examdb.hasExam(key)) {
    		return Response.status(409).build();
    	}

        if (examdb.modifyExamDescription(key, exam)) {
        	return Response.status(200).build();
        }
        
        return Response.status(500).build();
    }

}
		
	














