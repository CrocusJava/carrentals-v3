package carglassfish.ua.bionic.carrentals.entitybeans.placebean;

import java.util.List;

import javax.ejb.Local;

import carglassfish.ua.bionic.carrentals.entities.Place;

@Local
public interface PlaceBeanLocal {
	
	public void create(Place place);

	public void edit(Place place);

	public void remove(Place place);

	public Place find(Object id);

	public List<Place> findAll();

	public List<Place> findRange(int[] range);

	public int count();
	
	public List<Place> findAllSortedByCity();
}
