package com.hibernate.Demohib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAO {

	private static SessionFactory sessionFactory;

	// Add a constructor that accepts a SessionFactory
    public EmployeeDAO(SessionFactory sessionFactory) {
        EmployeeDAO.sessionFactory = sessionFactory;
    }

    public Employee findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createNativeQuery("SELECT * FROM Employee WHERE id = :id", Employee.class)
                          .setParameter("id", id)
                          .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Employee> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Employee E WHERE E.name = :employee_name";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            query.setParameter("employee_name", name);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Employee> findByNameAndDepartment(String name, int departmentId) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
            Root<Employee> root = query.from(Employee.class);

            Predicate namePredicate = builder.equal(root.get("name"), name);
            Predicate departmentPredicate = builder.equal(root.get("department").get("id"), departmentId);
            query.select(root).where(builder.and(namePredicate, departmentPredicate));

            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Map<String, Object> getSalaryForEmpId(int empId) {
        try (Session session = sessionFactory.openSession()) {
            String sql = "SELECT e.name, e.department_id, s.amount FROM employee e JOIN salary s ON e.id = s.emp_id WHERE e.id = :employee_id";
            Query<Object[]> query = session.createNativeQuery(sql);
            query.setParameter("employee_id", empId);
            Object[] result = query.getSingleResult();

            if (result != null) {
                Map<String, Object> salaryInfo = new HashMap<>();
                salaryInfo.put("name", result[0]);
                salaryInfo.put("departmentId", result[1]);
                salaryInfo.put("amount", result[2]);
                return salaryInfo;
            } else {
                return Collections.emptyMap();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }
}
