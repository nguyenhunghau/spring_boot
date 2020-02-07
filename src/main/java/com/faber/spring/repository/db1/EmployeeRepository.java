package com.faber.spring.repository.db1;

import com.faber.spring.model.db1.Employee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Thuan
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
    //This is a query method.
    Employee findById(int id);
    
    List<Employee> findAll();
    
}
