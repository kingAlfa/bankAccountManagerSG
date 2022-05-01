
package sg.server;

import java.util.ArrayList;
import java.util.List;
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
import sg.server.model.Operations;
import sg.server.service.ClientService;
import sg.server.wrapper.OperationWrapper;
import sg.server.wrapper.OperationResponse;

/**
 * La classe du routing de l'application.
 * Cette classe expose les differentes requetes que peu recevoir le service.
 * @author alpha
 *
 */
@Path("/sg")
public class MyResource {
	
	/**
	 * Le service qui gere les differentes operations d'un client
	 */
	ClientService clientService = ClientService.getService();
    
	/**
	 * 
	 * @param Client le client qui veut s'enregistrer et créer son compte
	 * @return OperationResponse le corps d'une operation effectué
	 */
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
    
    /**
     * 
     * @param id l'identifiant du client
     * @return Client le client dont l'identifiant correspond
     */
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
    
    /**
     * 
     * @param credit le montant a deposer
     * @return OperationResponse 
     */
    @PUT
    @Path("/client/credit")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public OperationResponse deposit(OperationWrapper credit) {
    	try {
    		return clientService.setCredit(credit.getIdClient(),credit.getnumeroAccount(),credit.getMontant());
    	}
    	catch(Exception exception) {
    		exception.printStackTrace();
    		return null;
    	}
    }
    
    /**
     * 
     * @param debit le montant a retirer
     * @return OperationResponse
     */
    @PUT
    @Path("/client/debit")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public OperationResponse withDraw(OperationWrapper debit) {
    	try {
    		return clientService.setDebit(debit.getIdClient(),debit.getnumeroAccount(),debit.getMontant());
    	}
    	catch(Exception exception) {
    		exception.printStackTrace();
    		return null;
    	}
    }
    
    /**
     * 
     * @param id l'identifiant du client 
     * @return List<Operations> liste des operations
     */
    @GET
    @Path("/client/history/{id}")
    @Produces("application/json")
    public List<Operations> history(@PathParam("id") UUID id){
    	try {
    		return clientService.getOperations(id);
    	}catch(Exception exception) {
    		exception.printStackTrace();
    		return new ArrayList<Operations>();
    	}
    }
    
    
}
