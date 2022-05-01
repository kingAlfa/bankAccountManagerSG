package sg.server.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import sg.server.interfaces.BankInterface;
import sg.server.type.TypeOperation;



public class StandardAccount implements BankInterface {
	private Client client;
	private int numeroAccount;
	private Double solde;
	private List<Operations> operations;
	
	public StandardAccount(Client client,int numero) {
		this.client=client;
		this.numeroAccount=numero;
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
	 * 
	 * @param montant
	 */
	private void setOperation(Double montant,TypeOperation type) {
		Date instant = Calendar.getInstance().getTime();
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
