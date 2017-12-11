package Quickshop;
// Adding customer details and methods. 
public class Customer extends User {
private int customerID;
private Product AddProduct;
private Product RemoveProduct;
private Seller SearchProduct;
private Order Checkout;
private Cart Cart;
private Seller SearchStore;
private Payment Payment;
private Saved_Product SaveProduct;
<<<<<<< HEAD
private String order;
=======
private String Review; 
private String order;
protected String getReview() {
	return Review;
}
>>>>>>> 240f17a3e059edd88570442bb3bcac32dc16af95


protected int getCustomerID() {
	return customerID;
}

protected void setCustomerID(int customerID) {
	this.customerID = customerID;
}
public Product getAddProduct(){
	return AddProduct;
}
public Saved_Product SaveProduct(){
	return SaveProduct;
}
public Product RemoveProduct(){
	return RemoveProduct;
}
public Seller SearchProduct(){
	return SearchProduct;
}
public Order Checkout(){
	return Checkout;
}
public Cart getCart(){
	return Cart;
}
public Seller SearchStore(){
	return SearchStore;
}
public Payment getPayment(){
	return Payment;
	
}
public void update(Order order);		// Observer design pattern : Observer



}
