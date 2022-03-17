package com.shopping;
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
class TestShopping {
private static SessionFactory sessionfactory;
private Session session;
	@BeforeAll//executed before all test methods to initialize resources
	public static void setUpBeforeClass() throws Exception
	{
	sessionfactory=Helper.getSessionFactory();
	System.out.println("Session factory is created...");
	}
	@AfterAll//executed after all test methods to close resources
	public static void tearDownAfterClass() throws Exception 
	{
	if(sessionfactory!=null)
	sessionfactory.close();
	System.out.println("Session Factory is destroyed...");
	}
	@BeforeEach//executed before each test case
	public void openSession() throws Exception 
	{
	session=sessionfactory.openSession();
	System.out.println("Session is created...");
	}
	@AfterEach//executed after each test case
	public void  closeSession() throws Exception 
	{
	if(session!=null)
	session.close();
	System.out.println("Session is closed...");
	}
	@Test
	@Order(1)
	public void testCreate() 
	{
	System.out.println("Test create is running...");
	session.beginTransaction();
	PurchaseDetails p1=new PurchaseDetails();
	p1.setProduct_name("Redmi 9A");
	p1.setProduct_type("Mobile");
	p1.setCost(7999f);
	PurchaseDetails p2=new PurchaseDetails();
	p2.setProduct_name("DSLR Camera");
	p2.setProduct_type("optical instrment");
	p2.setCost(12999f);
	ArrayList<PurchaseDetails> customer1=new ArrayList<PurchaseDetails>();
	customer1.add(p1);
	customer1.add(p2);
	CustomerDetails c1=new CustomerDetails();
	c1.setName("Gokul");
	c1.setMail_id("gokul33@gmail.com");
	c1.setPhone_number(9879869786l);
	c1.setAddress("#3,Lakshmi street,Kolkata,West Bengal,India");
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
	int customer_id=1;
	CustomerDetails upd=session.find(CustomerDetails.class, customer_id);
	upd.setName("David");
	upd.setMail_id("daviddanny23@gmail.com");
	session.beginTransaction();
	session.update(upd);
	session.getTransaction().commit();
	assertEquals("daviddanny23@gmail.com",upd.getMail_id());
	}
	@Test
	@Order(3)
	public void testGet()
	{
	System.out.println("Test get is running...");
	int customer_id=1;
	CustomerDetails read=session.find(CustomerDetails.class,customer_id);
	assertEquals("David",read.getName());	
	}
	@Test
	@Order(4)
	public void testList()
	{
	System.out.println("Test List is running...");
	Query query=session.createQuery("from CustomerDetails",CustomerDetails.class);
	List<CustomerDetails> z=query.getResultList();
	Assertions.assertFalse(z.isEmpty());
	}
	@Test
	@Order(5)
	public void testDelete()
	{
	System.out.println("Test delete is running...");
	int customer_id=1;
	CustomerDetails del=session.find(CustomerDetails.class,customer_id);
	session.beginTransaction();
	session.delete(del);
	session.getTransaction().commit();
	CustomerDetails deleted_details=session.find(CustomerDetails.class,customer_id);
	Assertions.assertNull(deleted_details);
	}
}


