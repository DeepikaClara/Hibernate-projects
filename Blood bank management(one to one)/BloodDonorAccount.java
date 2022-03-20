package com.onetoone;

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
public class BloodDonorAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@PrimaryKeyJoinColumn
private int donor_id;
private String Hospital_name;
private String date;
@OneToOne(targetEntity=BloodBankMembers.class,cascade=CascadeType.ALL)
private BloodBankMembers Donor;
public BloodDonorAccount() {
	super();
	// TODO Auto-generated constructor stub
}
public BloodDonorAccount(String hospital_name, String date) {
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
public BloodBankMembers getDonor() {
	return Donor;
}
public void setDonor(BloodBankMembers donor) {
	Donor = donor;
}

}
