package sg.server.service;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import sg.server.dataBase.DataBase;
import sg.server.model.Client;
import sg.server.model.StandardAccount;
import sg.server.type.TypeOperation;
import sg.server.wrapper.OperationResponse;

public class ClientService {
	DataBase database = DataBase.getDataBase();

	/**
	 * 
	 * @return
	 */
	public static ClientService getService() {
		return new ClientService();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
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
			
			StandardAccount account = new StandardAccount(newClient,Math.abs(ThreadLocalRandom.current().nextInt()));
			database.listAccount.add(account);
			
			OperationResponse response = new OperationResponse(newClient.getId(),
																newClient.getFirstName(),
																account.getNumeroAccount(),
																TypeOperation.CREATION,
																0.0,0.0);
			
			return response;
		}
		else {
			for (Client client:database.listDesClients) {
				if(client.equals(newClient)) {
					
					//A changer les informations du compte sont a chercher
					StandardAccount account = new StandardAccount(client,ThreadLocalRandom.current().nextInt());
					database.listAccount.add(account);
					
					OperationResponse response = new OperationResponse(client.getId(),
																		client.getFirstName(),
																		account.getNumeroAccount(),
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
	public OperationResponse setCredit(UUID idClient, int numeroAccount,Double montant) {
		StandardAccount compte =null;
		for(StandardAccount account : database.listAccount) {
			if(account.getClient().getId().equals(idClient) & account.getNumeroAccount() == numeroAccount) {
				account.credit(montant);
				compte=account;
			}
		}
		if(compte != null) {
			return new OperationResponse(compte.getClient().getId(),
										compte.getClient().getFirstName(),
										compte.getNumeroAccount(),
										TypeOperation.CREDIT,
										montant,compte.getSolde());
		}
		return null;
	}

}
