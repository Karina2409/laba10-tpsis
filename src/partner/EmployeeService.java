package partner;

import entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.EmployeeRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByLogin(String login){
        return employeeRepository.findEmployeeByLogin(login);
    }

    public void changeEmployeeRole(String login) { employeeRepository.changeEmployeeRole(login); }
}
