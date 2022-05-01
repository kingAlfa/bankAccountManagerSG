package sg.server.dataBase;

import java.util.ArrayList;

import sg.server.model.Client;
import sg.server.model.StandardAccount;

/**
 * Cette classe qui est un singleton represente la base de données afin de faciliter 
 * la manipulation des données
 * @author alpha
 *
 */
public class DataBase {
	private static DataBase database;
	/**
	 * Liste des clients de la banque
	 */
	public ArrayList<Client> listDesClients;
	/**
	 * Liste des compte de la banque. Chaque compte est lié a un utilisateur
	 */
	public ArrayList<StandardAccount> listAccount;
	
	private DataBase() {
		this.listDesClients= new ArrayList<Client>();
		this.listAccount = new ArrayList<StandardAccount>();
	}
	
	public static DataBase getDataBase() {
		if(database == null) {
			database=new DataBase();
		}
		return database;
	}
	
}
