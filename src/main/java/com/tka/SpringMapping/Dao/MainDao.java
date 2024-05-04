package com.tka.SpringMapping.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.SpringMapping.entity.Country;
import com.tka.SpringMapping.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	public String addcountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session =factory.openSession();
			
			tx=session.beginTransaction();
			
			session.persist(c);
			tx.commit();
			msg="Data added successfully";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
		
		
		
	}
	
	public String updatecountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session =factory.openSession();
			
			tx=session.beginTransaction();
			
			Country country=session.get(Country.class, c.getId());
			country.setCname(c.getCname());
			session.merge(country);
			
			
			tx.commit();
			msg="Data added successfully";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
		
		
	}
	
	
	public String deletecountry(int id) {
		
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session =factory.openSession();
			
			tx=session.beginTransaction();
			
			Country country=session.get(Country.class, id);
			
			session.remove(country);
			
			
			tx.commit();
			msg="Data delete successfully";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
		
	}
	
	public String getcountry(int id) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session =factory.openSession();
			
			tx=session.beginTransaction();
			
			String hqlquery="from Country where id=:myid";
			
			Query<Country>query=session.createQuery(hqlquery,Country.class);
			query.setParameter("myid", id);
			
			Country coun=query.uniqueResult();
			
			System.out.println(coun);
			
			tx.commit();
			msg="data get succssesfull";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
		
	}
	
	
	
public String getallcountry() {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session =factory.openSession();
			
			tx=session.beginTransaction();
			
			String hqlquery="from Country";
			
			Query<Country>query=session.createQuery(hqlquery,Country.class);

			
			List<Country>list=query.getResultList();
			
			System.out.println(list);
			
			tx.commit();
			msg="data getall succssesfull";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
		
	}
	
	
	
public String addEmployee(Employee e) {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
		
		session =factory.openSession();
		
		tx=session.beginTransaction();
		
		session.persist(e);
		
		tx.commit();
		msg="Employee data added  succssesfull";
		
	} catch (Exception e1) {
		
		
		if(tx!=null) {
			tx.rollback();
		}
		e1.printStackTrace();
	}finally {
		if(session != null) {
			session.close();
		}
	}
	
	return msg;
	
}



public String updateEmployee(Employee e) {

Session session=null;
Transaction tx=null;
String msg=null;

try {
	
	session =factory.openSession();
	
	tx=session.beginTransaction();
	
	Employee emp=session.get(Employee.class, e.getId());
	emp.setName(e.getName());
	emp.setPhoneno(e.getPhoneno());
	emp.setCountry(e.getCountry());
	emp.setCreatedby(e.getCreatedby());
	emp.setDepartment(e.getDepartment());
	emp.setStatus(e.getStatus());
	emp.setUpdatedby(e.getUpdatedby());
	emp.setCereteddtm(e.getCereteddtm());
	
	session.merge(emp);
	
	tx.commit();
	msg="Employee data updated  succssesfull";
	
} catch (Exception e1) {
	// TODO: handle exception
	
	if(tx!=null) {
		tx.rollback();
	}
	e1.printStackTrace();
}finally {
	if(session != null) {
		session.close();
	}
}

return msg;
	
	
}

public String deleteEmployee(int id) {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	try {
		
		session =factory.openSession();
		
		tx=session.beginTransaction();
		
		Employee emp=session.get(Employee.class, id);
		
		session.remove(emp);
		
		tx.commit();
		msg="Employee data added  succssesfull";
		
	} catch (Exception e1) {
		
		
		if(tx!=null) {
			tx.rollback();
		}
		e1.printStackTrace();
	}finally {
		if(session != null) {
			session.close();
		}
	}
	
	return msg;
	
}



public Employee getEmployee(int id) {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	Employee emp = null;
	
	
	try {
		
		session =factory.openSession();
		
		tx=session.beginTransaction();
		
	     //emp=session.get(Employee.class, id);  orrrr
		
		
		
		String query="from Employee where id=:myid";
		
		Query<Employee> q=session.createQuery(query,Employee.class);
		
		q.setParameter("myid",id);
		
		Employee emp1=q.uniqueResult();
		System.out.println(emp1);
	     
		
		
		tx.commit();
		msg="Employee data get  succssesfull";
		
	} catch (Exception e1) {
		
		
		if(tx!=null) {
			tx.rollback();
		}
		e1.printStackTrace();
	}finally {
		if(session != null) {
			session.close();
		}
	}
	
	return emp;
	
}


public List<Employee> getallEmployee () {
	
	Session session=null;
	Transaction tx=null;
	String msg=null;
	
	List<Employee> list=null;
	
	
	try {
		
		session =factory.openSession();
		
		tx=session.beginTransaction();
		
	     //emp=session.get(Employee.class, id);  orrrr
		
		
		
		String query="from Employee";
		
		Query<Employee> q=session.createQuery(query,Employee.class);
		
		list=q.list();
		
		
		
		
		tx.commit();
		msg="Employee data get  succssesfull";
		
	} catch (Exception e1) {
		
		
		if(tx!=null) {
			tx.rollback();
		}
		e1.printStackTrace();
	}finally {
		if(session != null) {
			session.close();
		}
	}
	
	return list;
	
}

}
