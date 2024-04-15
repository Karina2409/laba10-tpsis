package entity;

import lombok.Data;

@Data
@Entity
@Table(name = "raws")
public class Raw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO
    @Column
    private long id;
    @Column
    private String provider;
    @Column
    private float price;
    @Column
    private int quantity;
    @Column
    private String name;

    public Raw() {
    }

    public Raw(String provider, float price, int quantity, String name) {
        this.provider = provider;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }
}
