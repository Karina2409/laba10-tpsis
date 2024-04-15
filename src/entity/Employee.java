package entity;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO
    @Column
    private long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String surname;
    @Column
    private String name;
    @Column
    private String otchestvo;
    @Column
    private String email;
    @Column
    private String adress;
    @Column
    private String phone_number;
    @Column
    private float oklad;
    @Column
    private String post;
    @Column
    private String role;

    public Employee(String login, String password, String email) {
    }

    public Employee(String login, String password, String surname, String name, String otchestvo, String email, String adress, String phone_number, float oklad, String post, String role) {
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.otchestvo = otchestvo;
        this.email = email;
        this.adress = adress;
        this.phone_number = phone_number;
        this.oklad = oklad;
        this.post = post;
        this.role = role;
    }
}
