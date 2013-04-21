package carglassfish.ua.bionic.carrentals.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * User class is entity that describe information about user
 * 
 * @author Tkachuk
 */
@Entity
@Table(name="user")
@NamedQueries({
	@NamedQuery(name="User.findByLogin", query="SELECT u FROM User u WHERE u.login = :login"),
	@NamedQuery(name="User.findByEmail", query="SELECT u FROM User u WHERE u.email = :email")
})

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	protected Integer id;
	
	@Column(name="role")
	protected String role;
	
	@Column(name="login")
	protected String login;
	
	@Column(name="password")
	protected String password;
	
	@Column(name="email")
	protected String email;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="surname")
	protected String surname;
	
	@Column(name="middlename")
	protected String middlename;
	
	@OneToOne(mappedBy="user")
	protected Client client;
	
	/**
     * Constructor creates User with undefined field values
     */
	public User() {
	}
	
	/**
     * Constructor creates User with specified field values
     *
     * @param role user role
     * @param login user login
     * @param password user password
     * @param email user email
     * @param name user name
     * @param surname user surname
     * @param middlename user middlename
     */
	
	public User(String role, String login, String password,
			String email, String name, String surname, String middlename) {
		this.role = role;
		this.login = login;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.middlename = middlename;
	}
	
	/**
     * Constructor creates User with specified field values
     *
     * @param id user id
     * @param role user role
     * @param login user login
     * @param password user password
     * @param email user email
     * @param name user name
     * @param surname user surname
     * @param middlename user middlename
     */
	
	public User(Integer id, String role, String login, String password,
			String email, String name, String surname, String middlename) {
		this(role, login, password, email, name, surname, middlename);
		this.id=id;
	}
	
	/**
     * Constructor creates User with specified field values
     *
     * @param id user id
     * @param role user role
     * @param login user login
     * @param password user password
     * @param email user email
     * @param name user name
     * @param surname user surname
     * @param middlename user middlename
     * @param user
     */
	
	public User(Integer id, String role, String login, String password,
			String email, String name, String surname, String middlename,
			Client client) {
		this(id,role, login, password, email, name, surname, middlename);
		this.client=client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public Client getClient(){
		return client;
	}

	public void setClient(Client client){
		this.client=client;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((middlename == null) ? 0 : middlename.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (middlename == null) {
			if (other.middlename != null)
				return false;
		} else if (!middlename.equals(other.middlename))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("ID User=").append(id);
		desc.append("\nRole=").append(role);
		desc.append("\nLogin=").append(login);
		desc.append("\nPassword=").append(password);
		desc.append("\nEmail=").append(email);
		desc.append("\nName=").append(name);
		desc.append("\nSurname=").append(surname);
		desc.append("\nMiddlename=").append(middlename);
		return desc.toString();
	}
}
