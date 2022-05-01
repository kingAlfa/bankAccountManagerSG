package sg.server.wrapper;

import java.util.UUID;

/**
 * Operation Wrapper permet de surclasser les paramettres des requêtes 
 * @author alpha
 *
 */
public class OperationWrapper {
	private UUID idClient;
	private Double montant;
	private int numeroAccount;
	
	public OperationWrapper() {}
	
	public UUID getIdClient() {
		return idClient;
	}
	public void setIdClient(UUID idClient) {
		this.idClient = idClient;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public int getnumeroAccount() {
		return numeroAccount;
	}
	public void setnumeroAccount(int numeroAccount) {
		 this.numeroAccount=numeroAccount;
	}
	

}
