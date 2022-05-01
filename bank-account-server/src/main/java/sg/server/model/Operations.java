package sg.server.model;

import sg.server.type.TypeOperation;

/**
 * Cette classe represente une operation au sein de la banque dont debit ou credit.
 * Chaque operation est caracterisé par son type d'operation, la date de l'operation, le montant et le solde.
 * @author alpha
 *
 */
public class Operations {
	private TypeOperation operation;
	private String date;
	private Double montant;
	private Double solde;
	
	
	public TypeOperation getOperation() {
		return operation;
	}
	public void setOperation(TypeOperation operation) {
		this.operation = operation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
