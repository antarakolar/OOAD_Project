package Quickshop;

public interface OrderSubject {
	public void addUser(OrderObserver observer);
	public void removeUser (OrderObserver observer);
	public void notifyAllUsers();

}
