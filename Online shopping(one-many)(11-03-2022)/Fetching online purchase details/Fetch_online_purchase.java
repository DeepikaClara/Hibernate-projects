package one_to_many.Online_shopping;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Fetch_online_purchase {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		TypedQuery query=session.createQuery("From Customer_details");
		List<Customer_details> c=query.getResultList();
		Iterator<Customer_details> itr1=c.iterator();
		while(itr1.hasNext())
		{
			Customer_details z=itr1.next();
			System.out.println("Customer Name: "+z.getName());
			System.out.println("Customer mail-id: "+z.getMail_id());
			List<Purchase_details> p=z.getPurchases();
			Iterator <Purchase_details>itr2=p.iterator();
			while(itr2.hasNext())
			{
				Purchase_details y=itr2.next();
				System.out.println("product name: "+y.getProduct_name()+" "+"product type:"+y.getProduct_type());
				
			}
		}
		session.close();
		System.out.println("Customer's purchase has been fetched..");

	}

}
