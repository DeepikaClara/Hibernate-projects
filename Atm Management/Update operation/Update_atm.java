package hibernate_projects.sample_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update_atm {

	public static void main(String[] args) {
		SessionFactory s=new Configuration().configure()
				.addAnnotatedClass(Atm.class).buildSessionFactory();
		Session g=s.openSession();
		Transaction t=g.beginTransaction();
		try
		{
			String account_holder_name="Deepa";
			Atm update=g.get(Atm.class, account_holder_name);
			update.setAccountnumber(13245);
			t.commit();
		}
finally
{
	s.close();
	System.out.println("Data will be deleted");
}
	}

}
