package entity;

import lombok.Data;

@Data
@Entity
@Table(name = "partners")
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String type;
    @Column
    private String phone_number;

    public Partner() {
    }

    public Partner(String name, String email, String type, String phone_number) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.type = type;
    }
}
