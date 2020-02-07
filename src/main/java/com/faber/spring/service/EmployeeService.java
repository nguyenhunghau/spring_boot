package com.faber.spring.service;

import com.faber.spring.model.db1.Employee;
import com.faber.spring.repository.db1.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thuan
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee getEmployeeById(int id) {
        Employee obj = repository.findById(id);
        return obj;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Transactional("firstTransactionManager")
    @Override
    public synchronized boolean addEmployee(Employee employee) {
        repository.save(employee);
        return true;
    }

//    @Override
//    public void updateEmployee(Employee employee) {
//        employeeDAO.updateEmployee(employee);
//    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
