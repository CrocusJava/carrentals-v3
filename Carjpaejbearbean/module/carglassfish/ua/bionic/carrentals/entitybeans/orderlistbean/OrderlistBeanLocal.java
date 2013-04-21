package carglassfish.ua.bionic.carrentals.entitybeans.orderlistbean;

import java.util.List;

import javax.ejb.Local;

import carglassfish.ua.bionic.carrentals.entities.Orderlist;

@Local
public interface OrderlistBeanLocal {

	public void create(Orderlist orderlist);

	public void edit(Orderlist orderlist);

	public void remove(Orderlist orderlist);

	public Orderlist find(Object id);

	public List<Orderlist> findAll();

	public List<Orderlist> findRange(int[] range);

	public int count();
	
	public List<Orderlist> findAllSortedById();
}
