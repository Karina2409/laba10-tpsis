package service;

import entity.Email;
import entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
    private final TemplateRenderer templateRenderer;
    private final EmailSender emailSender;

    public void sendWelcomeEmail(Employee employee) {
        String welcomeEmailContent = generateWelcomeEmailContent(employee);

        Email email = new Email();
        email.setTo(employee.getEmail());
        email.setSubject("Welcome to our service!");
        email.setBody(welcomeEmailContent);

        emailSender.send(email);
    }

    private String generateWelcomeEmailContent(Employee employee) {
        Map<String, Object> context = new HashMap<>();
        context.put("login", employee.getLogin());

        return templateRenderer.render("welcome-email", context);
    }
}
