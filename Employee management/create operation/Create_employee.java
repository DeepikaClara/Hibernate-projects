package hibernate_projects.sample_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Create_employee {
public static void main(String args[])
{
	SessionFactory s=new Configuration().configure().
			addAnnotatedClass(Employee.class).buildSessionFactory();
	Session g=s.openSession();
	Transaction t=g.beginTransaction();
	try
	{
		//Employee emp1=new Employee("Karthick",25000d,"karthi1543@gmail.com");
		//Employee emp2=new Employee("Senthil",200000d,"senthilkumar@gmail.com");
		//Employee emp3=new Employee("Maha",30000d,"maha44@gmail.com");
		Employee emp4=new Employee("Kadhir",25000d,"kadhir1543@gmail.com");
		Employee emp5=new Employee("Suganthi",200000d,"suganthikumar@gmail.com");
		Employee emp6=new Employee("Malathi",30000d,"malathi44@gmail.com");
		g.save(emp4);
		g.save(emp5);
		g.save(emp6);
		t.commit();
	}
	finally
	{
		s.close();
		System.out.println("Data is saved");
	}
}
}
