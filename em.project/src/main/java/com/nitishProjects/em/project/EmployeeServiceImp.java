package com.nitishProjects.em.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepositery employeeRepositery;
    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
      EmployeeEntity employeeEntity = new EmployeeEntity();
      BeanUtils.copyProperties(employee, employeeEntity);

      employeeRepositery.save(employeeEntity);
       // employees.add(employee);
        return "Saved successfuly";
    }
        

    @Override
    public List<Employee> readEmployee() {
      List<EmployeeEntity> employeesList =employeeRepositery.findAll();
      List<Employee> employees= new ArrayList<>();

      for (EmployeeEntity employeeEntity : employeesList) {
          
        Employee emp = new Employee();
        emp.setId(employeeEntity.getId());
        emp.setName(employeeEntity.getName());
        emp.setEmail(employeeEntity.getEmail());
        emp.setPhone(employeeEntity.getPhone());

        employees.add(emp);
      }
      return employees;
    }

    
    
    @Override
    public boolean deleteEmployee(long id) {
     List EmployeeEntity emp = employeeRepository.findById(id).get();
      employeeRepository.delete(emp);
        return true;
    }

   
}

