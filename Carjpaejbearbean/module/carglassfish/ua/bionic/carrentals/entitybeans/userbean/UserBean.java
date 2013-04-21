package carglassfish.ua.bionic.carrentals.entitybeans.userbean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import carglassfish.ua.bionic.carrentals.entities.User;
import carglassfish.ua.bionic.carrentals.entitybeans.AbstractFacade;
import carglassfish.ua.bionic.carrentals.loggerbean.LoggerBean;

/**
 * Session Bean implementation class UserBean
 */
@Interceptors(LoggerBean.class)
@Stateless(mappedName = "UserBean")
@LocalBean
public class UserBean extends AbstractFacade<User> implements UserBeanLocal {
	@PersistenceContext(unitName="CarrentalsPU")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public UserBean() {
        super(User.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public User findByLogin(String login){
		User user=null;
		try {
			user=em.createNamedQuery("User.findByLogin",User.class).setParameter("login", login).getSingleResult();
		} catch (NoResultException e) {
			/*LOG*/ e.printStackTrace();
		} 
			return user;
	}
	
	public User checkByLoginPassword(String login, String password){
		User user=null;
		try {
		user=em.createNamedQuery("User.findByLogin",User.class).setParameter("login", login).getSingleResult();
		if (!(user.getPassword().equals(password))){
			user=null;
		}
		} catch (NoResultException e) {
			/*LOG*/ e.printStackTrace();
		} 
		return user;
	}
	
	public User createUser(String login, String password, String email, String name, String surname, String middlename){	
		User user=null;
		try {
			user=em.createNamedQuery("User.findByLogin",User.class).setParameter("login", login).getSingleResult();
			user=em.createNamedQuery("User.findByEmail",User.class).setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			/*LOG*/ e.printStackTrace();
		} 
		if (user.equals(null)){
			user=new User();
			user.setLogin(login);
			user.setEmail(email);
			user.setName(name);
			user.setSurname(surname);
			user.setMiddlename(middlename);
			create(user);
		}
		return user;
	}
	
	public User updateUser(User user, String login, String password, String email, String name, String surname, String middlename){
		user.setLogin(login);
		user.setPassword(password);
		user.setEmail(email);
		user.setName(name);
		user.setSurname(surname);
		user.setMiddlename(middlename);
		
		edit(user);
		
		return user;
	}
}
