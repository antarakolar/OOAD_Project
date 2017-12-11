package Quickshop;

public class Product {
	private int productId;
	private String productName;
	private String productCategory;
	private int productCost; 
	private String productDescription;
	private Seller seller; 
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(int productDescription) {
		this.productDescription = productDescription;
	}
	
	public Seller getSellerId() {
		return seller; 
	}
	

}
