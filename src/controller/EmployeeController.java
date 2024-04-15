package controller;

import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class EmployeeController {
    @Autowired  //аннотация Spring Framework, используемая для автоматического внедрения зависимостей
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

    @PostMapping("/employee")
    public void changeRole(@PathVariable String login){employeeService.changeEmployeeRole(login)}
}
