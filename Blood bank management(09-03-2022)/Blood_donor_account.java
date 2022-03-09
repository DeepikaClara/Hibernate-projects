package com.one_to_one_mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Blood_donor_account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
private int donor_id;
private String Hospital_name;
private String date;
@OneToOne(targetEntity=Humanity_Bloodbank.class,cascade=CascadeType.ALL)
private Humanity_Bloodbank Donor;
public Blood_donor_account() {
	super();
	// TODO Auto-generated constructor stub
}
public Blood_donor_account(String hospital_name, String date) {
	super();
	Hospital_name = hospital_name;
	this.date = date;
	//Donor = donor;
}
public int getDonor_id() {
	return donor_id;
}
public void setDonor_id(int donor_id) {
	this.donor_id = donor_id;
}
public String getHospital_name() {
	return Hospital_name;
}
public void setHospital_name(String hospital_name) {
	Hospital_name = hospital_name;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public Humanity_Bloodbank getDonor() {
	return Donor;
}
public void setDonor(Humanity_Bloodbank donor) {
	Donor = donor;
}

}
