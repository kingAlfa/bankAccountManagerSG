package sg.server.interfaces;

import java.util.List;

import sg.server.model.Client;
import sg.server.model.Operations;

/**
 * L'interface qui represente une banque. On pourra ainsi etendre cette interface si on veut d'autre type de Compte bancaire
 * @author alpha
 *
 */
public interface BankInterface {
	public Double credit(Double montant);
	public Double debit(Double montant);
	public Double getSolde();
	public List<Operations> getOperations();
	public Client getClient();
	public int getNumeroAccount();

}
