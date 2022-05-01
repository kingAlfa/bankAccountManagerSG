package sg.server.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import sg.server.dataBase.DataBase;
import sg.server.model.Client;
import sg.server.model.StandardAccount;
import sg.server.type.TypeOperation;
import sg.server.wrapper.OperationResponse;

public class ClientService {
	DataBase database = DataBase.getDataBase();

	public static ClientService getService() {
		return new ClientService();
	}

	
	public Client getUser(UUID id) {
		for(Client client:database.listDesClients) {
			if(client.getId().equals(id)) {
				return client;
			}
		}
		return new Client();
	}
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public OperationResponse createClient(String firstName, String lastName) {
		
		Client newClient = new Client();
		newClient.setFirstName(firstName);
		newClient.setLastName(lastName);
		newClient.setId();
		
		if(!database.listDesClients.contains(newClient)) {
			database.listDesClients.add(newClient);
			
			StandardAccount account = new StandardAccount(newClient,new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			database.listAccount.add(account);
			
			OperationResponse response = new OperationResponse(newClient.getId(),
																newClient.getFirstName(),
																Integer.toString(account.getNumeroAccount()),
																TypeOperation.CREATION,
																0.0,0.0);
			
			return response;
		}
		else {
			for (Client client:database.listDesClients) {
				if(client.equals(newClient)) {
					database.listAccount.add(new StandardAccount(client,new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())));
					
					StandardAccount account = new StandardAccount(client,new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
					database.listAccount.add(account);
					
					OperationResponse response = new OperationResponse(client.getId(),
																		client.getFirstName(),
																		Integer.toString(account.getNumeroAccount()),
																		TypeOperation.CREATION,
																		0.0,0.0);
					return response;
				}
			}
			
		}
		return null;
		
	}

	/**
	 * 
	 * @param idClient
	 * @param montant
	 * @return
	 */
	public OperationResponse setCredit(UUID idClient, String numeroAccount,Double montant) {
		// TODO Auto-generated method stub
		return null;
	}

}
