package sg.server.model;

import java.util.Date;

import sg.server.type.TypeOperation;

public class Operations {
	private TypeOperation operation;
	private Date date;
	private Double montant;
	private Double solde;
	public TypeOperation getOperation() {
		return operation;
	}
	public void setOperation(TypeOperation operation) {
		this.operation = operation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
}
