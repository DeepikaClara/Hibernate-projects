package atmmanagement;
import org.hibernate.HibernateException;
import org.hibernate.Session;
public class Create {
private Session session;
public Create()
{
	session=Utility.getSession();
	session.beginTransaction();
}
public void values() throws HibernateException
{
	Atm a=new Atm(11297,"Amritha",7689567894l);
	Atm b=new Atm(12345,"Balu",9878986785l);
	Atm c=new Atm(13245,"Deepa",7879896787l);
	Atm d=new Atm(14564,"Vanitha",8979687809l);
	session.save(a);
	session.save(b);
	session.save(c);
	session.save(d);
	session.getTransaction().commit();
	session.close();
}
	public static void main(String[] args) {
		 
		try
		{
			Create a1=new Create();
			a1.values();
			System.out.println("Data has been saved...");
			
			}
catch(HibernateException h)
{
	
	System.out.println(h);
}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
