package com.nitishProjects.em.project;

import java.util.List;

public interface  EmployeeService {
    String  createEmployee(Employee employee);
        List<Employee> readEmployee();
        boolean deleteEmployee(long id);

    
}
 