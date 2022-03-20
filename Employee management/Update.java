package employeemanagement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
public class Update {
private Session g;
public Update()
{
	g=Utility.getSession();
	g.beginTransaction();
}
public  void updateValues()throws HibernateException
{
	int empid=3;
	Employee update=g.get(Employee.class,empid);
	update.setEname("Rakshitha");
	update.setSalary(30000d);
	update.setEmail("rakshitha@gmail.com");
	g.getTransaction().commit();
	g.close();
	System.out.println("Data is updated...");
}
	public static void main(String[] args) {
	try
	{
		Update u=new Update();
		u.updateValues();
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
