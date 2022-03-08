package hibernate_projects.sample_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update_Employee {

	public static void main(String[] args) {
	SessionFactory s=new Configuration().configure()
			.addAnnotatedClass(Employee.class).buildSessionFactory();
	Session g=s.openSession();
	Transaction t=g.beginTransaction();
	try
	{
		int empid=7;
		Employee update=g.get(Employee.class,empid);
		update.setEname("Rakshitha");
		update.setSalary(30000d);
		update.setEmail("rakshitha@gmail.com");
		
		t.commit();
		
	}
	finally
	{
		s.close();
		System.out.println("Data will be updated");
	}

	}

}
