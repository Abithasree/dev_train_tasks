package com.hibernate.Demohib;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(Salary.class);
        config.addAnnotatedClass(Department.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

        EmployeeDAO employeeDAO = new EmployeeDAO(sessionFactory);

        // Example usage:
        Employee employee = employeeDAO.findById(1);
        System.out.println("Employee found by id: " + employee.getName());

        List<Employee> employees = employeeDAO.findByName("John Doe");
        System.out.println("Employees found by name: ");
        for (Employee emp : employees) {
            System.out.println(emp.getName());
        }

        List<Employee> employeesByNameAndDept = employeeDAO.findByNameAndDepartment("John Doe", 1);
        System.out.println("Employees found by name and department: ");
        for (Employee emp : employeesByNameAndDept) {
            System.out.println(emp.getName() + " - " + emp.getDepartment().getName());
        }

        Map<String, Object> salaryInfo = employeeDAO.getSalaryForEmpId(1);
        if (salaryInfo != null) {
            System.out.println("Salary for Employee 1: " + salaryInfo.get("amount"));
            System.out.println("Employee Name: " + salaryInfo.get("name"));
            System.out.println("Department Id: " + salaryInfo.get("departmentId"));
        } else {
            System.out.println("No salary information found for Employee 1");
        }
    }
}
