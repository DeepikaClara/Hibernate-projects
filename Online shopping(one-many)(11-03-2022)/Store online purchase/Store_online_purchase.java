package one_to_many.Online_shopping;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Store_online_purchase {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
			Purchase_details p1=new Purchase_details("Pantene Advanced hairfall solution","Hair care product",450.0f);
			Purchase_details p2=new Purchase_details("Pears soft&fresh","skin care product",55.0f);
			Purchase_details p3=new Purchase_details("Mamaearth aloe veragel","skin care product",299.0f);
			Purchase_details p4=new Purchase_details("Organic nuts","food product",254.0f);
			ArrayList<Purchase_details> customer1=new ArrayList<Purchase_details>();
			customer1.add(p1);
			customer1.add(p2);
			ArrayList<Purchase_details> customer2=new ArrayList<Purchase_details>();
			customer2.add(p3);
			customer2.add(p4);
			Customer_details c1=new Customer_details("gk@gmail.com","Gokul",9878987678l,"#3,Lakshmi st","chennai-91","TN","India");
			c1.setPurchases(customer1);
			Customer_details c2=new Customer_details("jaya23@gmail.com","Jaya",9878678956l,"#45,Raja st","Bangalore-26","Karnataka","India");
			c2.setPurchases(customer2);
			session.save(c1);
			session.save(c2);
			t.commit();
			factory.close();
			System.out.println("Customers' purchases has been entered");
			
	}

}
