package com.nitishProjects.em.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpController {

   // EmployeeService employeeService = new EmployeeServiceImp();
    //dependency injection
    @Autowired 
    EmployeeService employeeService;
 
   
    @GetMapping("/api/employees/{id}")
    public List<Employee> getAllEmloyees() {
       
        return employeeService.readEmployee();
    }

   // @PostMapping("employees")
   @PostMapping("/api/employees")
    public String createEmployee(@ModelAttribute Employee employee){
        //employees.add(employee);
       return  employeeService.createEmployee(employee);
        
    }
    // DELETE: Delete an employee by ID
    @DeleteMapping("/api/employees/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        boolean isDeleted = employeeService.deleteEmployee(id); // Assuming deleteEmployee returns boolean
        if (isDeleted) {
            return "Employee with ID " + id + " deleted successfully.";
        } else {
            return "Employee with ID " + id + " not found.";
        }
    }
    
    
}
