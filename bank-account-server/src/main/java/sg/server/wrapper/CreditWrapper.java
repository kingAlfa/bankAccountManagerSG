package sg.server.wrapper;

import java.util.UUID;

/**
 * 
 * @author alpha
 *
 */
public class CreditWrapper {
	private UUID idClient;
	private Double montant;
	private int numeroAccount;
	
	public CreditWrapper() {}
	
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
