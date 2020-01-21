package ru.geekbrains.entities;


import javax.persistence.*;

@Entity
@Table(name = "product_buyers")
public class ClientChoice {

    public ClientChoice() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Column(name = "client_id")
    private int client_id;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Column(name = "product_id")
    private int product_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @ManyToMany
//    @JoinTable(
//            name = "product_buyers",
//            joinColumns = @JoinColumn(name = "client_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//
//    @Override
//    public String toString() {
//        String allProducts = "";
//        for (Product o : products) {
//            allProducts += o.getTitle() + " ";
//        }
//        return "Clients_choice [" + " " + client_id + " " + allProducts +"]";
//    }
}
