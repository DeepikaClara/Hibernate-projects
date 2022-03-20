package employeemanagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {
	public static Session getSession()
	{
	SessionFactory s=new Configuration().configure()
			.addAnnotatedClass(Employee.class).buildSessionFactory();
	Session g=s.openSession();

	return g;
}
}
