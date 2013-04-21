package carglassfish.ua.bionic.carrentals.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Place class is entity that describe information about place of car
 * 
 * @author Tkachuk
 */
@Entity
@Table(name="place")
@NamedQuery(name="Place.sortedByCity", query="SELECT p FROM Place p ORDER BY p.city")
public class Place implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idplace")
	protected Integer idPlace;
	
	@Column(name="city")
	protected String city;
	
	@Column(name="description")
	protected String description;
	
	@OneToMany(mappedBy="placeGet")
	protected Set<Orderlist> orderlistsget=new HashSet<Orderlist>();
	
	@OneToMany(mappedBy="placeReturn")
	protected Set<Orderlist> orderlistsreturn=new HashSet<Orderlist>();
	
	@OneToMany (mappedBy = "place")
	protected Set<Car> carlists=new HashSet<Car>();
	
	
	/**
     * Constructor creates Place with undefined field values
     */
	public Place(){
		
	}
	/**
     * Constructor creates Car with specified field values
     *
     * @param idPlace place id
     * @param city city
     * @param description description place
     * @param orderlistsget
     * @param orderlistsreturn
     */
	public Place(Integer idPlace, String city,
			String description, HashSet<Orderlist> orderlistsget,
			HashSet<Orderlist> orderlistsreturn, HashSet<Car> carlists) {
		this.idPlace = idPlace;
		this.city = city;
		this.description = description;
		this.orderlistsget=orderlistsget;
		this.orderlistsreturn=orderlistsreturn;
		this.carlists=carlists;
	}

	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Integer idPlace) {
		this.idPlace = idPlace;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Orderlist> getOrderlistsget() {
		return orderlistsget;
	}

	public void setOrderlistsget(Set<Orderlist> orderlistsget) {
		this.orderlistsget = orderlistsget;
	}
	
	public Set<Orderlist> getOrderlistsreturn() {
		return orderlistsreturn;
	}

	public void setOrderlistsreturn(Set<Orderlist> orderlistsreturn) {
		this.orderlistsreturn = orderlistsreturn;
	}
	
	public Set<Car> getCar() {
		return carlists;
	}
	public void setCar(Set <Car> carlists) {
		this.carlists = carlists;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idPlace == null) ? 0 : idPlace.hashCode());
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
		Place other = (Place) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idPlace == null) {
			if (other.idPlace != null)
				return false;
		} else if (!idPlace.equals(other.idPlace))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("ID Place=").append(idPlace);
		desc.append("\nCity=").append(city);
		desc.append("\nDescription=").append(description);
		return desc.toString();
	}
}
