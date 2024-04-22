package partner;

import entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import repository.EmployeeRepository;

import java.io.IOException;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeRegistrationService {
    private EmployeeRepository employeeRepository;
    private EmailService emailService;

    public void registerEmployee(String login, String password, String email) {
        try {
            if (!isValidLogin(login)) {
                throw new IOException();
            }
        } catch (IOException e){
            System.out.println("Login wrong!");
        }
        try {
            if (!isValidPassword(password)) {
                throw new IOException();
            }
        } catch (IOException e){
            System.out.println("Password wrong!");
        }
        try {
            if (!isValidEmail(email)) {
                throw new IOException();
            }
        }
        catch (IOException e){
            System.out.println("Email wrong!");
        }
        // Сохранение данных
        Employee employee = new Employee(login, password, email);
        employeeRepository.createEmployee(employee);

        // Отправка письма
        emailService.sendWelcomeEmail(employee);
    }

    private boolean isValidLogin(String login) {
        if (login == null || login.isEmpty()) {
            return false;
        }

        if (login.length() < 6) {
            return false;
        }

        if (!Pattern.matches("[a-zA-Z0-9_.-]+", login)) {
            return false;
        }

        return true;
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!Pattern.matches("[a-zA-Z0-9!@#$%^&*()_+-=]+", password)) {
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        if (!Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", email)) {
            return false;
        }
        return true;
    }
}
