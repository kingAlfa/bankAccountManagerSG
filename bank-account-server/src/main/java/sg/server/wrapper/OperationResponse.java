package sg.server.wrapper;

import java.util.UUID;

import sg.server.type.TypeOperation;

/**
 * 
 * @author alpha
 *
 */
public class OperationResponse {
	private String nom;
	private UUID identifiant;
	private int account;
	private TypeOperation operation;
	private Double montant;
	private Double solde;
	/**
	 * 
	 * @param nom
	 * @param operation
	 * @param montant
	 * @param solde
	 */
	public OperationResponse(UUID id,String nom, int account,TypeOperation operation, Double montant, Double solde) {
		super();
		this.identifiant=id;
		this.nom = nom;
		this.account= account;
		this.operation = operation;
		this.montant = montant;
		this.solde = solde;
	}
	public OperationResponse() {}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public UUID getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(UUID identifiant) {
		this.identifiant = identifiant;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public TypeOperation getOperation() {
		return operation;
	}
	public void setOperation(TypeOperation operation) {
		this.operation = operation;
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
