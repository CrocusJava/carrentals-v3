package carglassfish.ua.bionic.carrentals.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import carglassfish.ua.bionic.carrentals.entities.Car;
import carglassfish.ua.bionic.carrentals.entitybeans.carbean.CarBeanLocal;

@ManagedBean(name="carmb")
@SessionScoped
public class Carmb implements Serializable{
	
	@EJB
	private CarBeanLocal carBean;
	
	private List<Car> carList = new ArrayList<Car>();
	
	public String getListCars(){
		carList=carBean.findAllSortedByPrice();
		return "/xhtml/cars/cars.xhtml?faces-redirect=true";
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	
}
