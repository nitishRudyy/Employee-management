package com.nitishProjects.em.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface EmployeeRepositery extends JpaRepository<EmployeeEntity,Long> {
    
}
