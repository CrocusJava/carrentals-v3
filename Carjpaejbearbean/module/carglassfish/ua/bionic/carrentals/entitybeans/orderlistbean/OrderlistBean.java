package carglassfish.ua.bionic.carrentals.entitybeans.orderlistbean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import carglassfish.ua.bionic.carrentals.entities.Car;
import carglassfish.ua.bionic.carrentals.entities.Client;
import carglassfish.ua.bionic.carrentals.entities.Orderlist;
import carglassfish.ua.bionic.carrentals.entities.Place;
import carglassfish.ua.bionic.carrentals.entities.User;
import carglassfish.ua.bionic.carrentals.entitybeans.AbstractFacade;
import carglassfish.ua.bionic.carrentals.entitybeans.clientbean.ClientBeanLocal;
import carglassfish.ua.bionic.carrentals.loggerbean.LoggerBean;

/**
 * Session Bean implementation class OrderlistBean
 */
@Interceptors(LoggerBean.class)
@Stateless(mappedName = "OrderlistBean")
@LocalBean
public class OrderlistBean extends AbstractFacade<Orderlist> implements
		OrderlistBeanLocal {
	@PersistenceContext(unitName = "CarrentalsPU")
	EntityManager em;

	@EJB
	ClientBeanLocal clientBean;

	/**
	 * Default constructor.
	 */
	public OrderlistBean() {
		super(Orderlist.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Orderlist> findAllSortedById() {
		List<Orderlist> orderlistList = null;
		try {
			orderlistList = em.createNamedQuery("Orderlist.sortedById",
					Orderlist.class).getResultList();
		} catch (PersistenceException e) {
			/* LOG */e.printStackTrace();
		}
		return orderlistList;
	}

	public Orderlist makeOrderlist(Car car, User user, Date dateGet,
			Date dateReturn, Place placeGet, Place placeReturn) {
		Orderlist orderlist = new Orderlist();

		Client client = clientBean.findByUser(user);

		if (!client.equals(null)) {
			orderlist.setClient(client);
			orderlist.setCar(car);
			orderlist.setDateGet(dateGet);
			orderlist.setDateReturn(dateReturn);
			orderlist.setPlaceGet(placeGet);
			orderlist.setPleceReturn(placeReturn);
		}

		create(orderlist);
		return orderlist;

	}

	public Orderlist changeStateOrderlist(Orderlist orderlist, Boolean stateOrder,
			String description, Boolean orderExecuted, String descriptionDamage) {

		orderlist.setStateOrder(stateOrder);
		orderlist.setDescription(description);
		orderlist.setOrderExecuted(orderExecuted);
		orderlist.setDescriptionDamage(descriptionDamage);

		edit(orderlist);
		return orderlist;
	}
}
