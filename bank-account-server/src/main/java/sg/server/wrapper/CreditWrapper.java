package sg.server.wrapper;

import java.util.UUID;

public class CreditWrapper {
	private UUID idClient;
	private Double montant;
	private String numeroAccount;
	
	
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
	public String getAccount() {
		return numeroAccount;
	}
	public void setAccount(String numeroAccount) {
		 this.numeroAccount=numeroAccount;
	}
	

}
