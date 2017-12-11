package Quickshop;
import java.util.ArrayList;
import java.util.HashSet;

public class Order implements OrderSubject{
private String OrderDate;
private int OrderID;
private String OrderDetails;
private Payment paymentTotal;
private String shippingMethod;
private Address address;
protected String getShippingMethod() {
	return shippingMethod;
}
protected void setShippingMethod(String shippingMethod) {
	this.shippingMethod = shippingMethod;
}
protected int getOrderID() {
	return OrderID;
}
protected void setOrderID(int orderID) {
	OrderID = orderID;
}

public Payment getPaymentTotal(){
	return paymentTotal;
}
public Address getAddress(){
	return address;
}
public static placeOrder() {
	return orderID;
}

public 

private HashSet<String> ordersets = new HashSet<String>();
private ArrayList<OrderObserver> observers = new ArrayList<OrderObserver>();
@Override
public void addUser(OrderObserver observer){
	observers.add(observer);
}
@Override
public void removeUser(OrderObserver observer){
	observers.remove(observer);
}
@Override
public void notifyAllUsers(){
	for(OrderObserver obs : observers){
			System.out.println("New Order Placed");
			obs.update(this.viewOrder());
	}
}
public String viewOrder(){
	return ordersets.toString();
}

}

