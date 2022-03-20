package employeemanagement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
public class Delete {
		private Session g;
		public Delete()
		{
			g=Utility.getSession();
			g.beginTransaction();
		}
		public void deleteValues()throws HibernateException
		{
			int empid=3;
			Employee del=g.get(Employee.class,empid);
			g.delete(del);
			g.getTransaction().commit();
			System.out.println("Data is deleted...");
		}
public static void main(String args[])
{
	try
	{
	Delete d=new Delete();
	d.deleteValues();
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
