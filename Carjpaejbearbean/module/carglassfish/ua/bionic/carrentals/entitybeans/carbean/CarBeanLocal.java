package carglassfish.ua.bionic.carrentals.entitybeans.carbean;

import java.util.List;

import javax.ejb.Local;

import carglassfish.ua.bionic.carrentals.entities.Car;
import carglassfish.ua.bionic.carrentals.entities.Place;

@Local
public interface CarBeanLocal {
	
	public void create(Car car);

	public void edit(Car car);

	public void remove(Car car);

	public Car find(Object id);

	public List<Car> findAll();

	public List<Car> findRange(int[] range);

	public int count();
	
	public List<Car> findAllSortedByPrice();
	
	public List<Car> findByPlacePrice(Place place, Integer price);

}
