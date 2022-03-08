package hibernate_projects.sample_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Read_Employee {

	public static void main(String[] args) {
		SessionFactory s=new Configuration().configure()
				.addAnnotatedClass(Employee.class).buildSessionFactory();
Session g=s.openSession();
try
{
	int empid=7;
	Transaction t=g.beginTransaction();
	Employee read=g.get(Employee.class, empid);
	System.out.println("Employee Id: "+read.getEmpid());
	System.out.println("Employee name: "+read.getEname());
	System.out.println("Employee email id: "+read.getEmail());
	System.out.println("Employee salary: "+read.getSalary());
	t.commit();
}
finally
{
	s.close();
	System.out.println("Data will be read");
}
	}

}
