package carglassfish.ua.bionic.carrentals.entitybeans.clientbean;

import java.util.List;

import javax.ejb.Local;

import carglassfish.ua.bionic.carrentals.entities.Client;
import carglassfish.ua.bionic.carrentals.entities.User;

@Local
public interface ClientBeanLocal {
	
	public void create(Client client);

	public void edit(Client client);

	public void remove(Client client);

	public Client find(Object id);

	public List<Client> findAll();

	public List<Client> findRange(int[] range);

	public int count();
	
	public Client findByUser(User user);

}
