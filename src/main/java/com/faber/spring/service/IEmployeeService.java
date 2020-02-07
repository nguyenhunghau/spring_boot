package com.faber.spring.service;

import com.faber.spring.model.db1.Employee;
import java.util.List;

/**
 *
 * @author Thuan
 */
public interface IEmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    boolean addEmployee(Employee employee);

//    void updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
