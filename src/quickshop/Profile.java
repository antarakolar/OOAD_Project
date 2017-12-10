package Quickshop;

public class Profile {


private String firstName;
private String lastName;
private String phoneNumber;
private String type;
private Address Address;
protected String getFirstName() {
	return firstName;
}
protected void setFirstName(String firstName) {
	this.firstName = firstName;
}
protected String getLastName() {
	return lastName;
}
protected void setLastName(String lastName) {
	this.lastName = lastName;
}
protected String getPhoneNumber() {
	return phoneNumber;
}
protected void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
protected String getType() {
	return type;
}
protected void setType(String type) {
	this.type = type;
}
public Address getAddress(){
	return Address;
}
}
