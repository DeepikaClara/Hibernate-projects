package atmmanagement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
public class Delete {
private Session session;
public Delete()
{
	session=Utility.getSession();
	session.beginTransaction();
}
public void deleteValues()throws HibernateException
{
	int account_no=12345;
	Atm del=session.get(Atm.class,account_no);
	session.delete(del);
	session.getTransaction().commit();
	session.close();
	System.out.println("Data has been deleted..");
}
	public static void main(String[] args) {
		try
		{
		Delete d=new Delete();
		d.deleteValues();
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