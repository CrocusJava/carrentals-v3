package carglassfish.ua.bionic.carrentals.entitybeans.clientbean;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import carglassfish.ua.bionic.carrentals.entities.Client;
import carglassfish.ua.bionic.carrentals.entities.User;
import carglassfish.ua.bionic.carrentals.entitybeans.AbstractFacade;
import carglassfish.ua.bionic.carrentals.loggerbean.LoggerBean;

/**
 * Session Bean implementation class ClientBean
 */
@Interceptors(LoggerBean.class)
@Stateless(mappedName = "ClientBean")
@LocalBean
public class ClientBean extends AbstractFacade<Client> implements ClientBeanLocal {
	@PersistenceContext(unitName="CarrentalsPU")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ClientBean() {
        super(Client.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Client findByUser(User user){
		Client client=null;
		try {
			client=em.createNamedQuery("Client.findByUser",Client.class).setParameter("user", user).getSingleResult();
		} catch (NoResultException e) {
			/*LOG*/ e.printStackTrace();
		} 
			return client;
	}
    
    public Client updateClient(User user, Date birthday, String passportseries, Integer passportnumber, Integer phonenumber){
    	Client client=findByUser(user);
    	
    	client.setBirthday(birthday);
    	client.setPassportseries(passportseries);
    	client.setPassportnumber(passportnumber);
    	client.setPhonenumber(phonenumber);
       	edit(client);
    	
    	return client;
    }
    

}
