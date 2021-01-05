package REST;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import DB.ServerDB;
import entities.Server;

@Path("/server")
public class ServerREST {

	private ServerDB serverdb = new ServerDB();

	@Path("")
	@POST
	public Response insertServer(Server server) {

		if (serverdb.hasIpPort(server)) {
			return Response.status(409).build();
		}

		if (serverdb.insertServer(server)) {
			return Response.status(201).build();
		}
		return Response.status(500).build();
	}

	@Path("")
	@GET
	@Produces("application/json")
	public ArrayList<Server> getAllServers() {
		return serverdb.getAllServers();
	}

	@Path("/ip/{ip}/port/{port}")
	@GET
	@Produces("application/json")
	public Server getServerFromIpPort(@PathParam("ip") String ip, @PathParam("port") String port) {
		return serverdb.getServerFromIpPort(ip, port);
	}
}
