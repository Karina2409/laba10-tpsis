package entity;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private float price;
    @Column
    private int quantity;
    @Column
    private float cost_price;

    public Product() {
    }

    public Product(String name, float price, int quantity, float cost_price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.cost_price = cost_price;
    }
}
