package repository;

import entity.Employee;
import entity.Raw;

@Repository
public class EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findAll(String login);

    Employee findEmployeeByLogin(String login);

    void changeEmployeeRole(String login);

    void createEmployee(Employee employee);
}
