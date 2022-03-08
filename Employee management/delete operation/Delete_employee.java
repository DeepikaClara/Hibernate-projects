package hibernate_projects.sample_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete_employee {
public static void main(String args[])
{
	SessionFactory s=new Configuration().configure()
			.addAnnotatedClass(Employee.class).buildSessionFactory();
	Session g=s.openSession();
	Transaction t=g.beginTransaction();
	try
	{
		int empid=3;
		Employee del=g.get(Employee.class,empid);
		g.delete(del);
		t.commit();
	}
	finally
	{
		s.close();
		System.out.println("Data will be deleted");
	}
}
}
