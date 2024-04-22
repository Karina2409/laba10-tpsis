package controller;

import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import partner.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // получить всех пользователей
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.listEmployee();
    }

    @GetMapping("/employee/employee-by-login/{login}")
    public Employee getEmployeeByLogin(@PathVariable String login) {
        return employeeService.getEmployeeByLogin(login);
    }

    @PostMapping("/employee/change-role")
    public void changeRole(@PathVariable String login){employeeService.changeEmployeeRole(login);}
}
