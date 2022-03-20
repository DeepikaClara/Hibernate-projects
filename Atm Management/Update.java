package atmmanagement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
public class Update {
private Session s;
public Update()
{
	s=Utility.getSession();
	s.beginTransaction();
}
public void updateValues()throws HibernateException
{
	int account_no=11297;
	Atm update=s.get(Atm.class, account_no);
	update.setAccount_holder_name("Vijay");
	s.getTransaction().commit();
	s.close();
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
