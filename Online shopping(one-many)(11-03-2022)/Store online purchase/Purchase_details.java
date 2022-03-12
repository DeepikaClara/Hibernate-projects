package one_to_many.Online_shopping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Purchase_details {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int product_id;
private String product_name;
	private String product_type;
private float cost;
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_type() {
	return product_type;
}
public void setProduct_type(String product_type) {
	this.product_type = product_type;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}

public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public Purchase_details(String product_name, String product_type, float cost) {
	super();
	this.product_name = product_name;
	this.product_type = product_type;
	this.cost = cost;
}
public Purchase_details() {
	super();
	// TODO Auto-generated constructor stub
}


}
