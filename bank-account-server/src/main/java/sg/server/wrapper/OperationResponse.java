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
	private String account;
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
	public OperationResponse(UUID id,String nom, String account,TypeOperation operation, Double montant, Double solde) {
		super();
		this.identifiant=id;
		this.nom = nom;
		this.account= account;
		this.operation = operation;
		this.montant = montant;
		this.solde = solde;
	}
	
}
