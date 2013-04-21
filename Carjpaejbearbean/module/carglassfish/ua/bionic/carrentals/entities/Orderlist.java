package carglassfish.ua.bionic.carrentals.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Order class is entity that describe all fields that belong order
 * 
 * @author Tkachuk
 */
@Entity
@Table(name = "orderlist")
@NamedQuery(name="Orderlist.sortedById", query="SELECT ol FROM Orderlist ol ORDER BY ol.idOrder")
public class Orderlist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idorder")
	protected Integer idOrder;
	
	@ManyToOne
	@JoinColumn(name="idcar", nullable=false)
	protected Car car;
	
	@ManyToOne
	@JoinColumn(name="idclient", nullable=false)
	protected Client client;
	
	@ManyToOne
	@JoinColumn(name="idplaceget", nullable=false)
	protected Place placeGet;
	
	@ManyToOne
	@JoinColumn(name="idplacereturn", nullable=false)
	protected Place placeReturn;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateget")
	protected Date dateGet;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datereturn")
	protected Date dateReturn;
	
	@Column(name="stateorder")
	protected Boolean stateOrder;
	
	@Column(name="description")
	protected String description;
	
	@Column(name="orderexecuted")
	protected Boolean orderExecuted;
	
	@Column(name="descriptiondamage")
	protected String descriptionDamage;
	
	/**
     * Constructor creates Order with undefined field values
     */
	public Orderlist(){
		
	}
	/**
     * Constructor creates Client with specified field values
     *
     * @param idOrder order id
     * @param Car car
     * @param Client client
     * @param Place place get
     * @param Place place return
     * @param dateGet date get
     * @param dateReturn date return
     * @param stateOrder order state
     * @param description order description in case deviation
     * @param orderExecuted order executed
     * @param descriptionDamage description damage
     * 
     */
	public Orderlist(Integer idOrder, Car car, Client client, 
			Place placeGet,	Place placeReturn, Date dateGet,
			Date dateReturn, Boolean stateOrder, String description,
			Boolean orderExecuted, String descriptionDamage) {

		this.idOrder = idOrder;
		this.car = car;
		this.client = client;
		this.placeGet = placeGet;
		this.placeReturn = placeReturn;
		this.dateGet = dateGet;
		this.dateReturn = dateReturn;
		this.stateOrder = stateOrder;
		this.description = description;
		this.orderExecuted = orderExecuted;
		this.descriptionDamage = descriptionDamage;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Place getPlaceGet() {
		return placeGet;
	}

	public void setPlaceGet(Place placeGet) {
		this.placeGet = placeGet;
	}

	public Place getPlaceReturn() {
		return placeReturn;
	}

	public void setPleceReturn(Place placeReturn) {
		this.placeReturn = placeReturn;
	}

	public Date getDateGet() {
		return dateGet;
	}

	public void setDateGet(Date dateGet) {
		this.dateGet = dateGet;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public Boolean getStateOrder() {
		return stateOrder;
	}

	public void setStateOrder(Boolean stateOrder) {
		this.stateOrder = stateOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getOrderExecuted() {
		return orderExecuted;
	}

	public void setOrderExecuted(Boolean orderExecuted) {
		this.orderExecuted = orderExecuted;
	}

	public String getDescriptionDamage() {
		return descriptionDamage;
	}

	public void setDescriptionDamage(String descriptionDamage) {
		this.descriptionDamage = descriptionDamage;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((dateGet == null) ? 0 : dateGet.hashCode());
		result = prime * result
				+ ((dateReturn == null) ? 0 : dateReturn.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((descriptionDamage == null) ? 0 : descriptionDamage
						.hashCode());
		result = prime * result + ((idOrder == null) ? 0 : idOrder.hashCode());
		result = prime * result
				+ ((orderExecuted == null) ? 0 : orderExecuted.hashCode());
		result = prime * result
				+ ((placeGet == null) ? 0 : placeGet.hashCode());
		result = prime * result
				+ ((placeReturn == null) ? 0 : placeReturn.hashCode());
		result = prime * result
				+ ((stateOrder == null) ? 0 : stateOrder.hashCode());
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
		Orderlist other = (Orderlist) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (dateGet == null) {
			if (other.dateGet != null)
				return false;
		} else if (!dateGet.equals(other.dateGet))
			return false;
		if (dateReturn == null) {
			if (other.dateReturn != null)
				return false;
		} else if (!dateReturn.equals(other.dateReturn))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (descriptionDamage == null) {
			if (other.descriptionDamage != null)
				return false;
		} else if (!descriptionDamage.equals(other.descriptionDamage))
			return false;
		if (idOrder == null) {
			if (other.idOrder != null)
				return false;
		} else if (!idOrder.equals(other.idOrder))
			return false;
		if (orderExecuted == null) {
			if (other.orderExecuted != null)
				return false;
		} else if (!orderExecuted.equals(other.orderExecuted))
			return false;
		if (placeGet == null) {
			if (other.placeGet != null)
				return false;
		} else if (!placeGet.equals(other.placeGet))
			return false;
		if (placeReturn == null) {
			if (other.placeReturn != null)
				return false;
		} else if (!placeReturn.equals(other.placeReturn))
			return false;
		if (stateOrder == null) {
			if (other.stateOrder != null)
				return false;
		} else if (!stateOrder.equals(other.stateOrder))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("Order=").append(idOrder);
		desc.append("\nClient=").append(client);
		desc.append("\nCar=").append(car);
		desc.append("\nPlace get=").append(placeGet);
		desc.append("\nPlace return=").append(placeReturn);
		desc.append("\nState order=").append(stateOrder);
		return desc.toString();
	}

}
