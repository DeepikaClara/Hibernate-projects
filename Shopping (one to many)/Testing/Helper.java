package com.shopping;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Helper {
	
	public static SessionFactory getSessionFactory()
	{
	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();	
	SessionFactory sf=new MetadataSources(ssr).buildMetadata().buildSessionFactory();
	return sf;
	}
}
