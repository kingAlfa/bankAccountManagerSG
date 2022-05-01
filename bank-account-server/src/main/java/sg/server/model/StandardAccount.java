package sg.server.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import sg.server.interfaces.BankInterface;
import sg.server.type.TypeOperation;


/**
 * Le type de compte bancaire par defaut. 
 * Chaque compte bancaire est caracterié par un client, un numero de compte, un solde et une liste d'operations
 * @author alpha
 *
 */
public class StandardAccount implements BankInterface {
	private Client client;
	private int numeroAccount;
	private Double solde;
	private List<Operations> operations;
	
	/**
	 * Pour créer un compte bancaire de maniére simple, on fourni le client.
	 * Le numero du compte , le solde sont alors affectés
	 * @param client le client
	 */
	public StandardAccount(Client client) {
		this.client=client;
		this.numeroAccount=Math.abs(ThreadLocalRandom.current().nextInt());
		this.solde=0.0;
		this.operations=new ArrayList<Operations>();
	}
	
	@Override
	public Double credit(Double montant) {
		this.solde = this.solde + montant;
		setOperation(montant,TypeOperation.CREDIT);
		return solde;
	}
	/**
	 * Initialisation d'une operation bancaire
	 * @param montant le montant de l'operation
	 * @param type le type de l'operation
	 */
	private void setOperation(Double montant,TypeOperation type) {
		DateFormat formater = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
		
		String instant = formater.format(new Date());
		Operations operation = new Operations();
		operation.setDate(instant);
		operation.setMontant(montant);
		operation.setOperation(type);
		operation.setSolde(solde);
		
		operations.add(operation);
	}

	@Override
	public Double debit(Double montant) {
		this.solde = this.solde - montant;
		setOperation(montant,TypeOperation.DEBIT);
		return solde;
	}

	@Override
	public Double getSolde() {
		return solde;
	}

	@Override
	public List<Operations> getOperations() {
		return operations;
	}

	@Override
	public Client getClient() {
		return client;
	}

	@Override
	public int getNumeroAccount() {
		return numeroAccount;
	}

}
