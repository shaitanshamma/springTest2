package ru.geekbrains.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
//@NamedQuery(name="Product.findMax", query="from Product where maxPrice = (select max(price) from Product.class )")
public class Product {

    public Product() {
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_buyers", // название таблицы
            joinColumns = @JoinColumn(name = "product_id"),  // то что связываем
            inverseJoinColumns = @JoinColumn(name = "client_id") // то на что связываем
    )
    private List<Client> clients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [" + id + " " + title + " " + price + "]";
    }
}
