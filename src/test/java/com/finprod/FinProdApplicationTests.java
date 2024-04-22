package test.java.com.finprod;

import controller.EmployeeController;
import entity.Employee;
import entity.Partner;
import entity.Product;
import entity.Report;
import repository.EmployeeRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static jdk.jfr.internal.jfc.model.Constraint.any;

@SpringBootTest
public class FinProdApplicationTests {
    @Test
    void contextLoads() {
    }

    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testRegister() {
        Employee employee = new Employee();
        employee.setLogin("testUser");
        employee.setPassword("testPassword");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee result = employeeController.register(employee);

        assertEquals(employee.getLogin(), result.getLogin());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testLogin() {
        Employee employee = new Employee();
        employee.setLogin("testUser");
        employee.setPassword("testPassword");

        when(employeeRepository.findByLogin(employee.getLogin())).thenReturn(employee);
        when(passwordEncoder.matches(employee.getPassword(), employee.getPassword())).thenReturn(true);

        Employee result = employeeController.login(employee);

        assertEquals(employee.getLogin(), result.getLogin());
        verify(employeeRepository, times(1)).findByLogin(employee.getLogin());
    }

    @Test
    public void testCreateOrder() {
        Product product = new Product();
        product.setId(1L);

        when(productRepository.save(any(Order.class))).thenReturn(product);

        Order result = employeeController.createProduct(product);

        assertEquals(product.getId(), result.getId());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setStatus("Submitted");

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productRepository.save(any(product.class))).thenReturn(product);

        Product result = employeeController.updateProduct(product.getId(), new ProductDto());

        assertEquals(product.getStatus(), result.getStatus());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testSubmitProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setStatus("Submitted");

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = employeeController.submitProduct(product.getId());

        assertEquals(product.getStatus(), result.getStatus());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testCancelProductEmployee() {
        Product product = new Product();
        product.setId(1L);
        product.setStatus("Cancelled");

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = employeeController.cancelProduct(product.getId());

        assertEquals(product.getStatus(), result.getStatus());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testPayProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setStatus("Paid");

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = employeeController.payProduct(product.getId());

        assertEquals(product.getStatus(), result.getStatus());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testLeaveReport() {
        Report report = new Report();
        report.setId(1L);
        report.setRating(5);

        when(employeeRepository.save(any(Review.class))).thenReturn(report);

        Review result = employeeController.leaveReview(1L, report);

        assertEquals(report.getRating(), result.getRating());
        verify(employeeRepository, times(1)).save(report);
    }

    @Test
    public void testCompleteProductAdmin() {
        Product product = new Product();
        product.setId(1L);
        product.setStatus("Выполнен");

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Order.class))).thenReturn(product);

        Product result = adminController.completeProduct(product.getId());

        assertEquals(product.getStatus(), result.getStatus());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testProcessProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setStatus("В процессе");

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Order result = adminController.processProduct(product.getId());

        assertEquals(product.getStatus(), result.getStatus());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testCancelProductAdmin() {
        Product product = new Product();
        product.setId(1L);
        product.setStatus("Отменен");

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = adminController.cancelProduct(product.getId());

        assertEquals(product.getStatus(), result.getStatus());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testCreatePartner() {
        Partner partner = new Partner();
        partner.setId(1L);
        partner.setName("Test Service");

        when(partnerRepository.save(any(Partner.class))).thenReturn(partner);

        Partner result = adminController.createPsrtner(partner);

        assertEquals(partner.getName(), result.getName());
        verify(partnerRepository, times(1)).save(partner);
    }

    @Test
    public void testUpdatePartner() {
        Partner partner = new Partner();
        partner.setId(1L);
        partner.setName("Updated Test Service");

        when(partnerRepository.findById(partner.getId())).thenReturn(Optional.of(partner));
        when(partnerRepository.save(any(Partner.class))).thenReturn(partner);

        Partner result = adminController.updateService(partner.getId(), partner);

        assertEquals(partner.getName(), result.getName());
        verify(partnerRepository, times(1)).save(partner);
    }

    @Test
    public void testDeletePartner() {
        Partner partner = new Partner();
        partner.setId(1L);

        doNothing().when(partnerRepository).deleteById(partner.getId());

        adminController.deleteService(partner.getId());

        verify(partnerRepository, times(1)).deleteById(partner.getId());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("UpdatedTestUser");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = adminController.updateUser(user.getId(), user);

        assertEquals(user.getUsername(), result.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setId(1L);

        doNothing().when(userRepository).deleteById(user.getId());

        adminController.deleteUser(user.getId());

        verify(userRepository, times(1)).deleteById(user.getId());
    }

    @Test
    public void testGetPartners() {
        List<Partner> partners = new ArrayList<>();
        partners.add(new Partner());

        when(partnerRepository.findAll()).thenReturn(services);

        List<Partner> result = employeeController.getServices();

        assertEquals(partners.size(), result.size());
        verify(partnerRepository, times(1)).findAll();
    }

    @Test
    public void testGetProduct() {
        Product product = new Product();
        product.setId(1L);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        Product result = employeeController.getProduct(product.getId());

        assertEquals(product.getId(), result.getId());
        verify(productRepository, times(1)).findById(product.getId());
    }

    @Test
    public void testFindAffordablePartners() {
        List<Partner> partners = new ArrayList<>();
        partners.add(new Partner());

        when(partnerRepository.findAffordablePartner(anyDouble())).thenReturn(partners);

        List<Partner> result = adminController.findAffordablePartners(100.0);

        assertEquals(partners.size(), result.size());
        verify(partnerRepository, times(1)).findAffordablePartners(anyDouble());
    }

    @Test
    public void testFindByNameContaining() {
        List<Partner> partners = new ArrayList<>();
        partners.add(new Partner());

        when(partnerRepository.findByNameContaining(anyString())).thenReturn(partners);

        List<Partner> result = adminController.findByNameContaining("Test");

        assertEquals(partners.size(), result.size());
        verify(partnerRepository, times(1)).findByNameContaining(anyString());
    }

    @Test
    public void testFindByAreaLessThanEqual() {
        List<Partner> partners = new ArrayList<>();
        partners.add(new Partner());

        when(partnerRepository.findByAreaLessThanEqual(anyInt())).thenReturn(partners);

        List<Partner> result = adminController.findByAreaLessThanEqual(100);

        assertEquals(partners.size(), result.size());
        verify(partnerRepository, times(1)).findByAreaLessThanEqual(anyInt());
    }
}
