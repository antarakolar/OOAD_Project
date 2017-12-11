package quickshop;

public class Seller extends User {
private int sellerID;
private String order;
private Product RemoveProduct;
private Product ViewProducts;
private Product Product; 

protected int getSellerID() {
	return sellerID;
}

protected void setSellerID(int sellerID) {
	this.sellerID = sellerID;
}
//public Product RemoveProduct(){
//	return RemoveProduct;
	
	
//}
public Product ViewProducts(){
	return ViewProducts;
}
public void update(Order order);		// Observer design pattern : Observer

public Product removeProduct() {
	return Product;
}
public Product getAddProduct() {
	return Product;
}

public void viewCategory() {
	
}
public void searchCategory() {
	
}


}
