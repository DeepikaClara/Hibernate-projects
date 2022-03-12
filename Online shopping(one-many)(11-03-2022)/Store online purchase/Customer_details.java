package one_to_many.Online_shopping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table
public class Customer_details {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int customer_id;
private String Name;
	private String mail_id;

private long phone_number;
private String addressline,city,state,country;
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="customer_id")

private List<Purchase_details>purchases;
public String getMail_id() {
	return mail_id;
}
public void setMail_id(String mail_id) {
	this.mail_id = mail_id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public long getPhone_number() {
	return phone_number;
}
public void setPhone_number(long phone_number) {
	this.phone_number = phone_number;
}
public String getAddressline() {
	return addressline;
}
public void setAddressline(String addressline) {
	this.addressline = addressline;
}

public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public List<Purchase_details> getPurchases() {
	return purchases;
}
public void setPurchases(List<Purchase_details> purchases) {
	this.purchases = purchases;
}
public Customer_details(String mail_id, String name, long phone_number, String addressline, String city, String state,
		String country) {
	super();
	this.mail_id = mail_id;
	Name = name;
	this.phone_number = phone_number;
	this.addressline = addressline;
	this.city = city;
	this.state = state;
	this.country = country;
}
public Customer_details() {
	super();
	// TODO Auto-generated constructor stub
}


}
