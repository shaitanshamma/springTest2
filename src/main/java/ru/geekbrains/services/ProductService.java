package ru.geekbrains.services;


import org.springframework.stereotype.Service;
import ru.geekbrains.entities.Product;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService<T> {
    List<Product> getAll();

    Optional<Product> get(Long id);

    Product save(Product product);

    List<Product> getProductByTitle(String title);

    List<Product> myProductByMaxPrice();

    List<Product> myProductByMinPrice();

    List<Product> myAwerageProduct(int min, int max);
}
