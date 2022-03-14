package one_to_many.Online_shopping;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(OrderAnnotation.class)
class Testing_Online_Shopping {
private static SessionFactory sessionfactory;
private Session session;
	@BeforeAll//executed before all test methods to initialize resources
	public static void setUpBeforeClass() throws Exception {
		sessionfactory=Helper.getSessionFactory();
		System.out.println("Session factory is created...");
	}

	@AfterAll//executed after all test methods to close resources
	public static void tearDownAfterClass() throws Exception {
		if(sessionfactory!=null)
			sessionfactory.close();
		System.out.println("Session Factory is destroyed...");
	}

	@BeforeEach//executed before each test case
	public void openSession() throws Exception {
		session=sessionfactory.openSession();
		System.out.println("Session is created...");
	}

	@AfterEach//executed after each test case
	public void  closeSession() throws Exception {
		if(session!=null)
			session.close();
		System.out.println("Session is closed...");
	}

	@Test
	@Order(1)
	public void testCreate() {
		System.out.println("Test create is running...");
		session.beginTransaction();
		Purchase_details p1=new Purchase_details("Pantene Advanced hairfall solution","Hair care product",450.0f);
		Purchase_details p2=new Purchase_details("Pears soft&fresh","skin care product",55.0f);
		ArrayList<Purchase_details> customer1=new ArrayList<Purchase_details>();
		customer1.add(p1);
		customer1.add(p2);
		Customer_details c1=new Customer_details("gk@gmail.com","Gokul",9878987678l,"#3,Lakshmi st","chennai-91","TN","India");
		c1.setPurchases(customer1);
		Integer Customer_id=(Integer)session.save(c1);
		session.getTransaction().commit();
		Assertions.assertTrue(Customer_id>0);
	}
	@Test
	@Order(2)
	public void testUpdate()
	{
	System.out.println("Test update is running...");
	int Customer_id=1;
	Customer_details c1=new Customer_details(Customer_id,"Balu","balu45@gmail.com",8796879586l,"#32,Nehru street","Hyderabad","Telangana","India");
	session.beginTransaction();
	session.update(c1);
	session.getTransaction().commit();
	Customer_details update=session.find(Customer_details.class, Customer_id);
	assertEquals("balu45@gmail.com",update.getMail_id());
	}
	@Test
	@Order(3)
	public void testGet()
	{
		System.out.println("Test get is running...");
		int Customer_id=1;
		Customer_details read=session.find(Customer_details.class,Customer_id);
		assertEquals("Balu",read.getName());	
	}
	@Test
	@Order(4)
	public void testList()
	{
		System.out.println("Test List is running...");
		Query query=session.createQuery("from Customer_details",Customer_details.class);
		List<Customer_details> z=query.getResultList();
		Assertions.assertFalse(z.isEmpty());
	}
	@Test
	@Order(5)
	public void testDelete()
	{
		System.out.println("Test delete is running...");
		int Customer_id=1;
		Customer_details del=session.find(Customer_details.class,Customer_id);
		session.beginTransaction();
		session.delete(del);
		session.getTransaction().commit();
		Customer_details deleted_details=session.find(Customer_details.class,Customer_id);
		Assertions.assertNull(deleted_details);
	}
}


