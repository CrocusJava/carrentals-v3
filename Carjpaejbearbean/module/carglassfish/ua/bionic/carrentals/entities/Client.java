package carglassfish.ua.bionic.carrentals.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Client class is entity that describe personal information about user
 * 
 * @author Tkachuk
 */
@Entity
@Table (name="client")
@NamedQuery(name="Client.findByUser", query="SELECT cl FROM Client cl WHERE cl.user=:user")
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idclient")
	protected Integer idClient;
	
	@Temporal(TemporalType.DATE)
	@Column(name="birthday")
	protected Date birthday;
	
	@Column(name="passportseries")
	protected String passportseries;
	
	@Column(name="passportnumber")
	protected Integer passportnumber;

	@Column(name="phonenumber")
	protected Integer phonenumber;
	
	@OneToOne
	@JoinColumn(name="iduser")
	protected User user;
	
	@OneToMany(mappedBy="client")
	protected Set<Orderlist> orderlists=new HashSet<Orderlist>();
	/**
     * Constructor creates Client with undefined field values
     */
	public Client() {

	}
	/**
     * Constructor creates Client with specified field values
     *
     * @param idClient client id
     * @param birthday client birthday
     * @param passportseries client passport series
     * @param passportnumber client passport number
     * @param phonenumber client phone number
     * @param user
     * @param orderlists
     */
	public Client(Integer idClient, Date birthday,
			String passportseries, Integer passportnumber, Integer phonenumber,
			User user, HashSet<Orderlist> orderlists) {
		this.idClient = idClient;
		this.birthday = birthday;
		this.passportseries = passportseries;
		this.passportnumber = passportnumber;
		this.phonenumber = phonenumber;
		this.user=user;
		this.orderlists=orderlists;
	
	}
	
	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassportseries() {
		return passportseries;
	}

	public void setPassportseries(String passportseries) {
		this.passportseries = passportseries;
	}

	public Integer getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(Integer passportnumber) {
		this.passportnumber = passportnumber;
	}

	public Integer getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user=user;
	}
	
	public Set<Orderlist> getOrderlists() {
		return orderlists;
	}

	public void setOrderlists(Set<Orderlist> orderlists) {
		this.orderlists = orderlists;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((idClient == null) ? 0 : idClient.hashCode());
		result = prime * result
				+ ((passportnumber == null) ? 0 : passportnumber.hashCode());
		result = prime * result
				+ ((passportseries == null) ? 0 : passportseries.hashCode());
		result = prime * result
				+ ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Client other = (Client) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		if (passportnumber == null) {
			if (other.passportnumber != null)
				return false;
		} else if (!passportnumber.equals(other.passportnumber))
			return false;
		if (passportseries == null) {
			if (other.passportseries != null)
				return false;
		} else if (!passportseries.equals(other.passportseries))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("ID Client=").append(idClient);
		desc.append("\nBirthday=").append(birthday);
		desc.append("\nPassport=").append(passportseries + " " + passportnumber);
		desc.append("\nPhone=").append(phonenumber);
		return desc.toString();
	}

}
