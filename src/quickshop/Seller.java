package quickshop;

public class Seller extends User {
private int sellerID;
private Product RemoveProduct;
private Product ViewProducts;

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
}
