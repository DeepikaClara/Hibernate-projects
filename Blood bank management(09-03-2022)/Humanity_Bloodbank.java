package com.one_to_one_mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Humanity_Bloodbank {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Registration_id;
	private String Name;
	private long phone_number;
	private String address_line;
	private String blood_group;
@OneToOne(targetEntity=Blood_donor_account.class)
private Blood_donor_account donations;
	int getRegistration_id() {
		return Registration_id;
	}
	public void setRegistration_id(int registration_id) {
		Registration_id = registration_id;
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
	public String getAddress_line() {
		return address_line;
	}
	public void setAddress_line(String address_line) {
		this.address_line = address_line;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	
	public Blood_donor_account getDonations() {
		return donations;
	}
	public void setDonations(Blood_donor_account donations) {
		this.donations = donations;
	}
	public Humanity_Bloodbank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Humanity_Bloodbank(String name, long phone_number, String address_line, String blood_group) {
		super();
		Name = name;
		this.phone_number = phone_number;
		this.address_line = address_line;
		this.blood_group = blood_group;
	}

}
