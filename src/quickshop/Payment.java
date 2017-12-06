package quickshop;

public class Payment {
private int paymentID;
private String paymentDate; 
private int paymentTotal;
private Credit_Card paymentDetails;
private String makePayment;
private Order showOrder;
private boolean paymade;

protected int getPaymentTotal() {
	return paymentTotal;
}

protected void setPaymentTotal(int paymentTotal) {
	this.paymentTotal = paymentTotal;
}

protected String getPaymentDate() {
	return paymentDate;
}

protected void setPaymentDate(String paymentDate) {
	this.paymentDate = paymentDate;
}

protected int getPaymentID() {
	return paymentID;
}

protected void setPaymentID(int paymentID) {
	this.paymentID = paymentID;
} 
public Credit_Card getpaymentDetails(){
	return paymentDetails;
}
// call order to display order. 
}
