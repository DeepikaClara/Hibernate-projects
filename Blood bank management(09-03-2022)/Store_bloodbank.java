package com.one_to_one_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Store_bloodbank {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().
				configure().build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf=meta.getSessionFactoryBuilder().build();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Humanity_Bloodbank hb1=new Humanity_Bloodbank("Shruthi",9089076799l,"#13,JK street,Chennai-91","b+ve");
		Humanity_Bloodbank hb2=new Humanity_Bloodbank("Arundhadhi",79869786587l,"#77,Kamaraj street,Thanjavur-45","O+ve");
		Blood_donor_account bd1=new Blood_donor_account("Vijaya Hospital","02-02-2022");
		Blood_donor_account bd2=new Blood_donor_account("Meenakshi hospital","12-01-2022");
		
		hb1.setDonations(bd1);
		bd1.setDonor(hb1);
		s.persist(bd1);
		hb2.setDonations(bd2);
		bd2.setDonor(hb2);
		s.persist(bd2);
		t.commit();
		s.close();
		System.out.println("Donor details saved");
	}


}
