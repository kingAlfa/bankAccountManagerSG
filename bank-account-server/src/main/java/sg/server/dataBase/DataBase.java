package sg.server.dataBase;

import java.util.ArrayList;

import sg.server.model.Client;
import sg.server.model.StandardAccount;

public class DataBase {
	private static DataBase database;
	
	public ArrayList<Client> listDesClients;
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
