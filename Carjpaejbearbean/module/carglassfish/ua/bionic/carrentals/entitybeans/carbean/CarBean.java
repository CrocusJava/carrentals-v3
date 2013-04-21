package carglassfish.ua.bionic.carrentals.entitybeans.carbean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import carglassfish.ua.bionic.carrentals.entities.Car;
import carglassfish.ua.bionic.carrentals.entities.Place;
import carglassfish.ua.bionic.carrentals.entitybeans.AbstractFacade;
import carglassfish.ua.bionic.carrentals.loggerbean.LoggerBean;

/**
 * Session Bean implementation class CarBean
 */
@Interceptors(LoggerBean.class)
@Stateless(mappedName = "CarBean")
@LocalBean
public class CarBean extends AbstractFacade<Car> implements CarBeanLocal {
	@PersistenceContext(unitName = "CarrentalsPU")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public CarBean() {
		super(Car.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Car> findAllSortedByPrice() {
		List<Car> carList = null;
		try {
			carList = em.createNamedQuery("Car.sortedByPrice", Car.class)
					.getResultList();
		} catch (PersistenceException e) {
			/* LOG */e.printStackTrace();
		}
		return carList;
	}

	public List<Car> findByPlacePrice(Place place, Integer price) {
		List<Car> carList = null;
		try {
			carList = em.createNamedQuery("Car.findByPlacePrice", Car.class)
					.setParameter("place", place).setParameter("price", price)
					.getResultList();
		} catch (PersistenceException e) {
			/* LOG */e.printStackTrace();
		}
		return carList;
	}
}
