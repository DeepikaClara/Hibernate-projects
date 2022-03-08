package hibernate_projects.sample_programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Create_atm {

	public static void main(String[] args) {
		SessionFactory s=new Configuration().configure()
				.addAnnotatedClass(Atm.class).buildSessionFactory();
		Session g=s.openSession();
		Transaction t=g.beginTransaction();
		try
		{
			Atm a=new Atm(11297,"Amritha","7689567894");
			Atm b=new Atm(12345,"Balu","9878986785");
			Atm c=new Atm(13245,"Deepa","7879896787");
			Atm d=new Atm(14564,"Vanitha","8979687809");
			g.save(a);
			g.save(b);
			g.save(c);
			g.save(d);
			t.commit();
			}
finally
{
	s.close();
	System.out.println("Data is saved");
}
	}

}
