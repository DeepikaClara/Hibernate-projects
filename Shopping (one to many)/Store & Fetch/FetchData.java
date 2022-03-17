package com.shopping;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
public class FetchData {
private Session session;
	public FetchData() 
	{
		System.out.println("creating session only 1 time...");
		session=Utility.getSession();
		System.out.println("session is created...");
	}
	void executeQuery() throws HibernateException
	{
		Query <CustomerDetails>query=session.createQuery("From CustomerDetails");
		List<CustomerDetails> c=query.getResultList();
		Iterator<CustomerDetails> itr1=c.iterator();
		while(itr1.hasNext())
		{
			CustomerDetails z=itr1.next();
			System.out.println("Customer Name: "+z.getName());
			System.out.println("Customer mail-id: "+z.getMail_id());
			List<PurchaseDetails> p=z.getPurchases();
			Iterator <PurchaseDetails>itr2=p.iterator();
			while(itr2.hasNext())
			{
				PurchaseDetails y=itr2.next();
				System.out.println("product name: "+y.getProduct_name()+" "+"product type:"+y.getProduct_type());
			}
		}
		session.close();
	}
	public static void main(String[] args) 
	{
	try 
	{
		FetchData f=new FetchData();
		f.executeQuery();
		System.out.println("Customer's purchase has been fetched..");
	}
	catch(HibernateException e) 
	{
		System.out.println(e);
	}
	catch(Exception d)
	{
		System.out.println(d);
	}
	
	}
}
	
