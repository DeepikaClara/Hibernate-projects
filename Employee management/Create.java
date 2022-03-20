package employeemanagement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
public class Create {
	private Session g;
	public Create()
	{
		g=Utility.getSession();
		g.beginTransaction();
	}
	public void createValues()throws HibernateException
	{
		Employee emp1=new Employee("Karthick",25000d,"karthi1543@gmail.com");
		Employee emp2=new Employee("Senthil",200000d,"senthilkumar@gmail.com");
		Employee emp3=new Employee("Maha",30000d,"maha44@gmail.com");
		Employee emp4=new Employee("Kadhir",25000d,"kadhir1543@gmail.com");
		Employee emp5=new Employee("Suganthi",200000d,"suganthikumar@gmail.com");
		Employee emp6=new Employee("Malathi",30000d,"malathi44@gmail.com");
		g.save(emp1);
		g.save(emp2);
		g.save(emp3);
		g.save(emp4);
		g.save(emp5);
		g.save(emp6);
		g.getTransaction().commit();
		g.close();
		System.out.println("Data is created...");
	}
public static void main(String args[])
{
	try
	{
		Create c=new Create();
		c.createValues();
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
