package hibernate_projects.sample_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete_atm {

	public static void main(String[] args) {
		SessionFactory s=new Configuration().configure()
				.addAnnotatedClass(Atm.class).buildSessionFactory();
		Session g=s.openSession();
		Transaction t=g.beginTransaction();
		try
		{
			int account_no=12345;
			Atm del=g.get(Atm.class,account_no);
			g.delete(del);
			t.commit();
		}
finally
{
	s.close();
	System.out.println("Data will be deleted");
}
	}

}