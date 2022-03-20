package employeemanagement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
public class Read {
private Session s;
public Read()
{
	s=Utility.getSession();
	s.beginTransaction();
}
public void readValues()throws HibernateException
{
	int empid=2;
	Employee read=s.get(Employee.class, empid);
	System.out.println("Employee Id: "+read.getEmpid());
	System.out.println("Employee name: "+read.getEname());
	System.out.println("Employee email id: "+read.getEmail());
	System.out.println("Employee salary: "+read.getSalary());
	s.getTransaction().commit();
	s.close();
	System.out.println("Data is read...");
}
	public static void main(String[] args) {
try
{
	Read r=new Read();
	r.readValues();
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
