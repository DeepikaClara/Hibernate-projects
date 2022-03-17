package com.shopping;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class StoreData {
	private Session session;
	public StoreData() 
	{
	session=Utility.getSession();
	Transaction t=session.beginTransaction();
	}
			void storeValues()throws HibernateException
			{
			PurchaseDetails p1=new PurchaseDetails();
			p1.setCost(450f);
			p1.setProduct_name("Pantene advanced hairfall solution");
			p1.setProduct_type("hair care product");
			PurchaseDetails p2=new PurchaseDetails();
			p2.setCost(50f);
			p2.setProduct_name("pears soft & freah soap");
			p2.setProduct_type("skin care product");
			PurchaseDetails p3=new PurchaseDetails();
			p3.setCost(299f);
			p3.setProduct_name("Mama Earth aloe vera gel");
			p3.setProduct_type("skin care product");
			PurchaseDetails p4=new PurchaseDetails();
			p4.setCost(3698f);
			p4.setProduct_name("Dynasty by S.Gill");
			p4.setProduct_type("Book");
			ArrayList<PurchaseDetails> customer1=new ArrayList<PurchaseDetails>();
			customer1.add(p1);
			customer1.add(p2);
			ArrayList<PurchaseDetails> customer2=new ArrayList<PurchaseDetails>();
			customer2.add(p3);
			customer2.add(p4);
			CustomerDetails c1=new CustomerDetails();
			c1.setName("Gokul");
			c1.setMail_id("gokul33@gmail.com");
			c1.setAddress("#45,Nehru street,chennai,TN,India");
			c1.setPhone_number(9876985760l);
			c1.setPurchases(customer1);
			CustomerDetails c2=new CustomerDetails();
			c2.setName("Jaya");
			c2.setMail_id("jaya67@gmail.com");
			c2.setAddress("#3,Kamaraj street,Bangalore,Karnataka,India");
			c2.setPhone_number(8767898765l);
			c2.setPurchases(customer2);
			session.save(c1);
			session.save(c2);
			session.getTransaction().commit();
			session.close();
			}
			public static void main(String[] args) 
			{	
			try 
			{
			StoreData s1=new StoreData();
			s1.storeValues();
			System.out.println("Customers' purchases has been entered");
			} 
			catch (HibernateException e) 
			{
			System.out.println(e);
			}
			catch(Exception d)
			{	
			System.out.println(d);
			}		
			}
			}
