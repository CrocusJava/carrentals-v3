package carglassfish.ua.bionic.carrentals.managedbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import carglassfish.ua.bionic.carrentals.entities.Client;
import carglassfish.ua.bionic.carrentals.entities.User;
import carglassfish.ua.bionic.carrentals.entitybeans.clientbean.ClientBeanLocal;
import carglassfish.ua.bionic.carrentals.entitybeans.userbean.UserBeanLocal;

//@ManagedBean(name="usermb")
@ManagedBean
@SessionScoped
public class Usermb implements Serializable{
	
	@EJB
	private UserBeanLocal userbean;
	@EJB
	private ClientBeanLocal clientbean;
	
	private User user;
	private User userNew;
	private Client client;
	private String login;
	private String password;
	
	public String findUser(){
		user=userbean.checkByLoginPassword(login, password);
		client=user.getClient();
		return "/xhtml/index.xhtml?faces-redirect=true";
	}
	
	public String outUser(){
		user=null;
		client=null;
		login=null;
		password=null;
		return "/xhtml/index.xhtml?faces-redirect=true";
	}
	
	public String showUserProfile(){
		if (client==null){
			client=user.getClient();
		}
		return "/xhtml/profile/profile.xhtml?faces-redirect=true";
	}
	
	public String updateProfile(){
		if (client!=null){
			clientbean.edit(client);
		}
		userbean.edit(user);
		return "/xhtml/profile/profile.xhtml?faces-redirect=true";
	}
	
	public String registration(){
		userNew=new User();
		return "/xhtml/registration/registration.xhtml?faces-redirect=true";
	}
	
	public String saveNewUser(){
		userNew.setRole("user");
		userbean.create(userNew);
		userNew=null;
		return "/xhtml/index.xhtml?faces-redirect=true";
	}
	
	public void makeClient(){
		if(user.getClient()==null){
			client=new Client();
		}
	}
	
	public void createClient(){
		if(user.getClient()==null){
		client.setUser(user);
		user.setClient(client);
		clientbean.create(client);
		}
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUserNew() {
		return userNew;
	}

	public void setUserNew(User userNew) {
		this.userNew = userNew;
	}
	
	
	
}
