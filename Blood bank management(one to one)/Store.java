package com.onetoone;


import org.hibernate.HibernateException;
import org.hibernate.Session;
public class Store {
private Session session;
public Store()
{
	session=Helper.getSession();
	session.beginTransaction();
}
public void addValues()throws HibernateException
{
	BloodBankMembers hb1=new BloodBankMembers("Shruthi",9089076799l,"#13,JK street,Chennai-91","b+ve");
	BloodBankMembers hb2=new BloodBankMembers("Arundhadhi",79869786587l,"#77,Kamaraj street,Thanjavur-45","O+ve");
	
	BloodDonorAccount bd1=new BloodDonorAccount("Vijaya Hospital","02-02-2022");
	BloodDonorAccount bd2=new BloodDonorAccount("Meenakshi hospital","12-01-2022");
	
	hb1.setDonations(bd1);
	bd1.setDonor(hb1);
	session.save(bd1);
	hb2.setDonations(bd2);
	bd2.setDonor(hb2);
	session.save(bd2);
	session.getTransaction().commit();
	session.close();
	System.out.println("Members and their respective donation details are added....");
	}
	public static void main(String[] args) {
		try
		{
			Store s=new Store();
			s.addValues();
		}
		catch(HibernateException h)
		{
			System.out.println(h);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


}
