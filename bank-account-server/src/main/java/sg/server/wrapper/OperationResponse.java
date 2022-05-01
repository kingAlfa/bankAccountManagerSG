package sg.server.wrapper;

import java.util.UUID;

import sg.server.type.TypeOperation;

/**
 * Operation response permet de surclasser l'objet qui est envoyer comme reponse en appel des requetes.
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
	 * @param nom le nom du client
	 * @param operation le type de l'operation effectué
	 * @param montant le montant de l'operation
	 * @param solde la somme total du compte
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
