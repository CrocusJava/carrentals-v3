package carglassfish.ua.bionic.carrentals.entitybeans.userbean;

import java.util.List;

import javax.ejb.Local;

import carglassfish.ua.bionic.carrentals.entities.User;

@Local
public interface UserBeanLocal {
	
	public void create(User user);

	public void edit(User user);

	public void remove(User user);

	public User find(Object id);

	public List<User> findAll();

	public List<User> findRange(int[] range);

	public int count();
	
	public User findByLogin(String login);
	
	public User checkByLoginPassword(String login, String password);
}
