package atmmanagement;

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
		int account_no=11297;
		Atm read=s.get(Atm.class, account_no);
		System.out.println("Account holder name: "+read.getAccount_holder_name());
		System.out.println("Account no.: "+read.getAccountnumber());
		System.out.println("Account holder's phone no.:"+read.getPhone_number());
		s.getTransaction().commit();
		s.close();
		System.out.println("data is read...");
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
