package REST;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import DB.ClientDB;
import entities.Client;

@Path("/client")
public class ClientREST {
	private ClientDB clientdb = new ClientDB();
	
	@Path("")
    @POST
    public Response insertClient(Client client){
	
		
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

}
