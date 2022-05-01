
package sg.server;

import java.beans.Expression;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sg.server.model.Client;
import sg.server.service.ClientService;
import sg.server.wrapper.CreditWrapper;
import sg.server.wrapper.OperationResponse;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/sg")
public class MyResource {
	
	ClientService clientService = ClientService.getService();
    
    // The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
    
    @POST
	@Path("/register")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
    public OperationResponse register(Client client) {
    	try {
    		return clientService.createClient(client.getFirstName(),client.getLastName());
    	}
    	catch(Exception exception) {
    		exception.printStackTrace();
    		return null;
    	}
    }
    
    @GET
    @Path("/client/{id}")
    @Produces("application/json")
    public Client getClient(@PathParam("id") UUID id) {
    	try {
    		return clientService.getUser(id);
    	}catch(Exception exception) {
    		exception.printStackTrace();
    		return null;
    	}
    }
    
    @PUT
    @Path("/client/credit")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public OperationResponse deposit(CreditWrapper credit) {
    	try {
    		return clientService.setCredit(credit.getIdClient(),credit.getAccount(),credit.getMontant());
    	}
    	catch(Exception exception) {
    		exception.printStackTrace();
    		return null;
    	}
    }
    
}
