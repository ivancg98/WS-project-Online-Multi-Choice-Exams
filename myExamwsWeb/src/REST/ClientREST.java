package REST;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import DB.ClientDB;
import DB.ExamDB;
import entities.Client;

@Path("/client")
public class ClientREST {
	
	private ClientDB clientdb = new ClientDB();
	
	@Path("")
    @POST
    public Response insertClient(Client client){
		
    	if(!clientdb.hasExam(client.getExamKey()) || clientdb.hasClient(client)) {
    		return Response.status(409).build();
    	}
		
        if (clientdb.insertClient(client)) {
        	return Response.status(201).build();
        }    
        return Response.status(500).build();
	}
	
    @Path("")
    @GET
    @Produces("application/json")
    public ArrayList<Client> getListClientsAllExams(){
        return clientdb.getListClientsAllExams();
    }
    
	@Path("/studentId/{key}")
    @GET
    @Produces("application/json")
	public ArrayList<Client> getListGradesOfClient(@PathParam("key") String key){
        return clientdb.getListGradesOfClient(key);
    }
	
	@Path("/examId/{examkey}")
    @GET
    @Produces("application/json")
	public ArrayList<Client> getListClientsOfExam(@PathParam("examkey") int examkey){
        return clientdb.getListClientsOfExam(examkey);
    }
	
    @Path("/{key}/{examkey}")
    @PUT
    public Response uploadGrade(@PathParam("key")  String key, @PathParam("examkey")  int examKey, Float grade){

    	Client client = new Client(key, examKey);
    		
    	if(!clientdb.hasClient(client)) {
    		return Response.status(409).build();
    	}

        if (clientdb.uploadGrade(client, grade)) {
        	return Response.status(200).build();
        }
        
        return Response.status(500).build();
    }

}
