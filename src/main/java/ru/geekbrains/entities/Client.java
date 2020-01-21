package ru.geekbrains.entities;




import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

//    @Basic(fetch = FetchType.LAZY)
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    private List<Product> product;

    public Client() {
    }

    @ManyToMany
    @JoinTable(
            name = "product_buyers",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Override
    public String toString() {
        String allProducts = "";
        for (Product o : products) {
            allProducts += o.getTitle() + " ";
        }
        return "Client [" + id + " " + name + " " + allProducts + "]";
    }
}
