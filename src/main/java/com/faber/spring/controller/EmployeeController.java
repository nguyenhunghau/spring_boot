package com.faber.spring.controller;

import com.faber.spring.model.db1.Employee;
import com.faber.spring.service.IEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Thuan
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/getListEmployees")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Employee>> getAllArticles() {
        List<Employee> list = (List<Employee>) employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @GetMapping("/employee-manager")
    public String employeeManager() {
        return "employee-manager";
    }
    
    @GetMapping("/employee-detail")
    public String employeeDetail() {
        return "employee-detail";
    }
    
    @GetMapping("/add-employee")
    public String addEmployee() {
        return "add-employee";
    }
    
//    @PostMapping("/getEmployeeDetail")
//    @ResponseBody
//    public ResponseEntity<Employee> getEmployeeDetail(@RequestParam("id") String id) {
//        Employee employee = employeeService.getEmployeeById(Integer.parseInt(id));
//        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//    }

    @PostMapping("/addEmployee")
    @ResponseBody
    public String addEmployee(@RequestParam("name") String name,
            @RequestParam("age") String age,
            @RequestParam("dept") String dept,
            @RequestParam("salary") String salary) {
        Employee ep = new Employee();
        ep.setName(name);
        ep.setAge(Integer.parseInt(age));
        ep.setDept(dept);
        ep.setSalary(Integer.parseInt(salary));
        Boolean result = employeeService.addEmployee(ep);
        return result +"";
    }
    
    @PostMapping("/deleteEmployee")
    @ResponseBody
    public String deleteEmployee(@RequestParam("id") String id) {
        int epId = Integer.parseInt(id);
        employeeService.deleteEmployee(epId);
        return "true";
    }

}
