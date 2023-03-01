package com.csi.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;


@Component
public class EmployeeDaoImpl implements EmployeeDao{

	private static SessionFactory factory= new AnnotationConfiguration().configure().buildSessionFactory();
	@Override
	public void saveData(Employee employee) {
		// TODO Auto-generated method stub
		
		Session session=  factory.openSession();
		
		org.hibernate.Transaction transaction = session.beginTransaction();
		
		session.save(employee);
		
		transaction.commit();
		
	}

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub
		
		Session session= factory.openSession();
		return session.createQuery("from Employee").list();
	}

}
