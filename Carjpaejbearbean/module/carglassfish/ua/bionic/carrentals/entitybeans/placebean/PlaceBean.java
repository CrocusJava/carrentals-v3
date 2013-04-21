package carglassfish.ua.bionic.carrentals.entitybeans.placebean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import carglassfish.ua.bionic.carrentals.entities.Place;
import carglassfish.ua.bionic.carrentals.entitybeans.AbstractFacade;
import carglassfish.ua.bionic.carrentals.loggerbean.LoggerBean;

/**
 * Session Bean implementation class PlaceBean
 */
@Interceptors(LoggerBean.class)
@Stateless(mappedName = "PlaceBean")
@LocalBean
public class PlaceBean extends AbstractFacade<Place> implements PlaceBeanLocal {
	@PersistenceContext(unitName="CarrentalsPU")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public PlaceBean() {
        super(Place.class);
    }

    @Override
	protected EntityManager getEntityManager() {
		return em;
	}
    
    public List<Place> findAllSortedByCity(){
    	List <Place> placeList=em.createNamedQuery("Place.sortedByCity", Place.class).getResultList();
    	return placeList;
    }
    
}
