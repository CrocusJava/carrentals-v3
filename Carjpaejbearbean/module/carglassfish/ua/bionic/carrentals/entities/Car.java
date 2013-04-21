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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Car class is entity that describe all fields that belong car
 * 
 * @author Tkachuk
 */

@Entity
@Table(name = "car")
@NamedQueries({
	@NamedQuery(name="Car.findByPlacePrice", query="SELECT c FROM Car c WHERE c.place=:place AND c.price<=:price ORDER BY c.price"),
	@NamedQuery(name="Car.sortedByPrice", query="SELECT c FROM Car c ORDER BY c.price")
})

public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idcar")
	protected Integer idCar;
	
	@Column(name="photo")
	protected String photo;
	
	@Column(name="price")
	protected Integer price;
	
	@Column(name="carnumber")
	protected String carNumber;

	@Column(name="brand")
	protected String brand;
	
	@Column(name="model")
	protected String model;
	
	@Column(name="color")
	protected String color;

	@Column(name="transmission")
	protected String transmission;

	@Column(name="quantitySeats")
	protected Integer quantitySeats;

	@Column(name="quantityDoors")
	protected Integer quantityDoors;

	@Column(name="conditioner")
	protected boolean conditioner;
	
	@OneToMany (mappedBy = "car")
	protected Set<Orderlist> orderlists=new HashSet<Orderlist>();
	
	@ManyToOne
	@JoinColumn(name="idplace", nullable=false)
	protected Place place;
	
	/**
     * Constructor creates Car with undefined field values
     */
	public Car() {

	}
	
	/**
     * Constructor creates Car with specified field values
     *
     * @param idCar car id
     * @param photo car photo
     * @param price car price per day
     * @param carNumber car number
     * @param brand car brand
     * @param model car model
     * @param color car color
     * @param transmission type of transmission
     * @param quantitySeats quantity seats
     * @param quantityDoors quantity doors
     * @param conditioner conditioner
     * @param orderlists
     * @param place
     */
	public Car(Integer idCar, String photo, Integer price,
			String carNumber, String brand, String model,
			String color, String transmission,
			Integer quantitySeats, Integer quantityDoors, boolean conditioner,
			HashSet<Orderlist> orderlists, Place place) {
		this.idCar = idCar;
		this.photo = photo;
		this.price = price;
		this.carNumber = carNumber;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.transmission = transmission;
		this.quantitySeats = quantitySeats;
		this.quantityDoors = quantityDoors;
		this.conditioner = conditioner;
		this.orderlists=orderlists;
		this.place=place;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getQuantitySeats() {
		return quantitySeats;
	}

	public void setQuantitySeats(Integer quantitySeats) {
		this.quantitySeats = quantitySeats;
	}

	public int getQuantityDoors() {
		return quantityDoors;
	}

	public void setQuantityDoors(Integer quantityDoors) {
		this.quantityDoors = quantityDoors;
	}

	public boolean isConditioner() {
		return conditioner;
	}

	public void setConditioner(boolean conditioner) {
		this.conditioner = conditioner;
	}
	
	public Set<Orderlist> getOrderlists() {
		return orderlists;
	}

	public void setOrderlists(Set<Orderlist> orderlists) {
		this.orderlists = orderlists;
	}
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((carNumber == null) ? 0 : carNumber.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (conditioner ? 1231 : 1237);
		result = prime * result + ((idCar == null) ? 0 : idCar.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((quantityDoors == null) ? 0 : quantityDoors.hashCode());
		result = prime * result
				+ ((quantitySeats == null) ? 0 : quantitySeats.hashCode());
		result = prime * result
				+ ((transmission == null) ? 0 : transmission.hashCode());
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
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (conditioner != other.conditioner)
			return false;
		if (idCar == null) {
			if (other.idCar != null)
				return false;
		} else if (!idCar.equals(other.idCar))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantityDoors == null) {
			if (other.quantityDoors != null)
				return false;
		} else if (!quantityDoors.equals(other.quantityDoors))
			return false;
		if (quantitySeats == null) {
			if (other.quantitySeats != null)
				return false;
		} else if (!quantitySeats.equals(other.quantitySeats))
			return false;
		if (transmission == null) {
			if (other.transmission != null)
				return false;
		} else if (!transmission.equals(other.transmission))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("\nBrand=").append(brand);
		desc.append("\nModel=").append(model);
		desc.append("\nCar number=").append(carNumber);
		return desc.toString();
	}

}
