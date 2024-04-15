package entity;

import lombok.Data;

@Data
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String date;
    @Column
    private String type;

    public Report() {
    }

    public Report(String name, String date, String type) {
        this.name = name;
        this.date = date;
        this.type = type;
    }
}
