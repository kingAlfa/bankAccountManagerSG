package sg.server.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import sg.server.interfaces.BankInterface;
import sg.server.type.TypeOperation;



public class StandardAccount implements BankInterface {
	private Client client;
	private String numeroAccount;
	private Double solde;
	private List<Operations> operations;
	
	public StandardAccount(Client client,String numero) {
		this.client=client;
		this.numeroAccount=numero;
		this.solde=0.0;
		this.operations=new ArrayList<Operations>();
	}
	
	@Override
	public Double credit(Double montant) {
		this.solde = this.solde + montant;
		setOperation(montant);
		return solde;
	}

	/**
	 * 
	 * @param montant
	 */
	private void setOperation(Double montant) {
		Date instant = Calendar.getInstance().getTime();
		Operations operation = new Operations();
		operation.setDate(instant);
		operation.setMontant(montant);
		operation.setOperation(TypeOperation.CREDIT);
		operation.setSolde(solde);
		
		operations.add(operation);
	}

	@Override
	public Double debit(Double montant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getSolde() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operations> getOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
