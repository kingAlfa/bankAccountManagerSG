package sg.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import sg.server.dataBase.DataBase;
import sg.server.model.Client;
import sg.server.model.Operations;
import sg.server.model.StandardAccount;
import sg.server.type.TypeOperation;
import sg.server.wrapper.OperationResponse;

public class ClientService {
	/**
	 * L'instance de la base de données
	 */
	DataBase database = DataBase.getDataBase();

	/**
	 * 
	 * @return ClientService une instance du service client
	 */
	public static ClientService getService() {
		return new ClientService();
	}

	/**
	 * 
	 * @param id l'identifiant du client
	 * @return Client le client dont l'identifiant correspond au paramétre
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
	 * Creation d'un client avec son nom et son prénom.
	 * Son identifiant et son sompte sont directement crée
	 * @param firstName
	 * @param lastName
	 * @return  OperationResponse qui est le resultat de l'operation
	 */
	public OperationResponse createClient(String firstName, String lastName) {
		
		Client newClient = new Client();
		newClient.setFirstName(firstName);
		newClient.setLastName(lastName);
		newClient.setId();
		
		if(!database.listDesClients.contains(newClient)) {
			database.listDesClients.add(newClient);
			
			StandardAccount account = new StandardAccount(newClient);
			database.listAccount.add(account);
			
			OperationResponse response = new OperationResponse(newClient.getId(),newClient.getFirstName(),account.getNumeroAccount(),TypeOperation.CREATION,0.0,0.0);
			
			return response;
		}
		else {
			for (Client client:database.listDesClients) {
				if(client.equals(newClient)) {
					for(StandardAccount account:database.listAccount) {
						if(account.getClient().getId().equals(client.getId())) {
							
							OperationResponse response = new OperationResponse(client.getId(),client.getFirstName(),account.getNumeroAccount(),TypeOperation.CREATION,0.0,0.0);
							return response;
						}
					}
					
				}
			}
			
		}
		return null;
		
	}

	/**
	 * Operation de depot de credit sur le compte du client
	 * @param idClient l'identifiant du client 
	 * @param montant 
	 * @return OperationResponse
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
			return new OperationResponse(compte.getClient().getId(),compte.getClient().getFirstName(),compte.getNumeroAccount(),TypeOperation.CREDIT,montant,compte.getSolde());
		}
		return null;
	}

	/**
	 * Operation de retrai sur le compte du client
	 * @param idClient l'identifiant du client 
	 * @param numeroAccount le numero du compte
	 * @param montant
	 * @return OperationResponse
	 */
	public OperationResponse setDebit(UUID idClient, int numeroAccount, Double montant) {
		StandardAccount compte =null;
		for(StandardAccount account : database.listAccount) {
			if(account.getClient().getId().equals(idClient) & account.getNumeroAccount() == numeroAccount) {
				account.debit(montant);
				compte=account;
			}
		}
		if(compte != null) {
			return new OperationResponse(compte.getClient().getId(),compte.getClient().getFirstName(),compte.getNumeroAccount(),TypeOperation.DEBIT,montant,compte.getSolde());
		}
		return null;
	}
	/**
	 * Operation de visualisation de l'historique des differentes operations effectuées
	 * @param id l'identifiant du client
	 * @return List<Operations> la liste de toutes les operations
	 */

	public List<Operations> getOperations(UUID id) {
		for(StandardAccount account :database.listAccount) {
			if(account.getClient().getId().equals(id)) {
				return account.getOperations();
			}
		}
		return new ArrayList<Operations>();
	}

}
