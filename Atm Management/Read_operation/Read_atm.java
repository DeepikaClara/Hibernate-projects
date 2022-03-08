package hibernate_projects.sample_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Read_atm {

	public static void main(String[] args) {
		SessionFactory s=new Configuration().configure()
				.addAnnotatedClass(Atm.class).buildSessionFactory();
		Session g=s.openSession();
		Transaction t=g.beginTransaction();
		try
		{
			int account_no=11297;
			Atm read=g.get(Atm.class, account_no);
			System.out.println("Account holder name: "+read.getAccount_holder_name());
			System.out.println("Account no.: "+read.getAccountnumber());
			System.out.println("Account holder's phone no.:"+read.getPhone_number());
			t.commit();
		}
		finally
		{
			s.close();
			System.out.println("data is read");
		}

	}

}
