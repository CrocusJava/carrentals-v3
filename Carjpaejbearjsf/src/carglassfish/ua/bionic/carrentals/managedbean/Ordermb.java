package carglassfish.ua.bionic.carrentals.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import carglassfish.ua.bionic.carrentals.entities.Car;
import carglassfish.ua.bionic.carrentals.entities.Orderlist;
import carglassfish.ua.bionic.carrentals.entities.Place;
import carglassfish.ua.bionic.carrentals.entitybeans.carbean.CarBeanLocal;
import carglassfish.ua.bionic.carrentals.entitybeans.orderlistbean.OrderlistBeanLocal;
import carglassfish.ua.bionic.carrentals.entitybeans.placebean.PlaceBeanLocal;

@ManagedBean(name="ordermb")
@SessionScoped
public class Ordermb implements Serializable {
	
	@EJB
	private CarBeanLocal carbean;
	@EJB
	private PlaceBeanLocal placebean;
	@EJB
	private OrderlistBeanLocal orderlistbean;
	
	@ManagedProperty (value="#{usermb}")
	private Usermb usermb;
	
	private List<Place> placeList;
	private List<Car> searchedCarList;
	private List<Orderlist> orderList;
	
	private Car car;
	private String placeGet;
	private String placeReturn;
	private Date dateGet=new Date();
	private Date dateReturn=new Date();
	private Integer price=100;
	
	private Orderlist order;
	
	public String showSearchForm(){
		placeList=placebean.findAllSortedByCity();
		return "/xhtml/search/search.xhtml?faces-redirect=true";
	}
	
	public String showSerchedCars(){
		Place plGet=placebean.find(Integer.valueOf(placeGet));
		searchedCarList=carbean.findByPlacePrice(plGet, price);
		return "/xhtml/search/searchedcars.xhtml?faces-redirect=true";
	}
	
	public String showOrderForm(Car car){
		this.car=car;
		if (placeList==null){
			placeList=placebean.findAllSortedByCity();
		}
		usermb.makeClient(); 
		return "/xhtml/orders/createorder.xhtml?faces-redirect=true";
	}
	
	public String createOrder(){
		usermb.createClient();
		order=new Orderlist();
		order.setCar(car);
		order.setClient(usermb.getClient());
		order.setDateGet(dateGet);
		order.setDateReturn(dateReturn);
		order.setPlaceGet(car.getPlace());
		order.setPleceReturn(placebean.find(Integer.valueOf(placeReturn)));
		orderlistbean.create(order);
		return "/xhtml/index.xhtml?faces-redirect=true";
	}
	
	public String showOrderList(){
		orderList=orderlistbean.findAllSortedById();
		return "/xhtml/orders/orderlist.xhtml?faces-redirect=true";
	}
	
	public String updateOrderList(){
		for (Orderlist ol : orderList) {
			orderlistbean.edit(ol);
		}
		return "/xhtml/orders/orderlist.xhtml?faces-redirect=true";
	}
	public CarBeanLocal getCarbean() {
		return carbean;
	}

	public void setCarbean(CarBeanLocal carbean) {
		this.carbean = carbean;
	}

	public PlaceBeanLocal getPlacebean() {
		return placebean;
	}

	public void setPlacebean(PlaceBeanLocal placebean) {
		this.placebean = placebean;
	}

	public List<Place> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<Place> placeList) {
		this.placeList = placeList;
	}

	public List<Car> getSearchedCarList() {
		return searchedCarList;
	}

	public void setSearchedCarList(List<Car> searchedCarList) {
		this.searchedCarList = searchedCarList;
	}

	public String getPlaceGet() {
		return placeGet;
	}

	public void setPlaceGet(String placeGet) {
		this.placeGet = placeGet;
	}

	public String getPlaceReturn() {
		return placeReturn;
	}

	public void setPlaceReturn(String placeReturn) {
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Orderlist getOrder() {
		return order;
	}

	public void setOrder(Orderlist order) {
		this.order = order;
	}

	public Usermb getUsermb() {
		return usermb;
	}

	public void setUsermb(Usermb usermb) {
		this.usermb = usermb;
	}

	public List<Orderlist> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orderlist> orderList) {
		this.orderList = orderList;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	

}
