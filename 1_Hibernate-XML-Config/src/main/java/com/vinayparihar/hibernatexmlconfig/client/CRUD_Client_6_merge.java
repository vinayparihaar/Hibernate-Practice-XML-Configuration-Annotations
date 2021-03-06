/**
 * 
 */
package com.vinayparihar.hibernatexmlconfig.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vinayparihar.hibernatexmlconfig.model.Employee;

/**
 * @author VinayParihar
 * @date May 13, 2020 @time 7:34:55 PM
 */
public class CRUD_Client_6_merge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Employee employee = (Employee) session.get(Employee.class, 4);

		employee.setEmployeeFirstName("Susheela");
		employee.setEmployeeLastName("Bai Parihar");
		employee.setEmployeeEmail("susheela@gmail.com");
		employee.setEmployeePhone("9999999999");

		Employee result = (Employee) session.merge(employee);

		Transaction transaction = session.getTransaction();
		transaction.commit();

		session.close();
		sessionFactory.close();
		
		System.out.println("Employee Id : " + result.getEmployeeId() + " Records updated Successfully!!");

	}

}
