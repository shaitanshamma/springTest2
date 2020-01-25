package ru.geekbrains.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import ru.geekbrains.entities.Product;

import java.util.List;

@Component
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByTitle(String title);

    //    @Query("select p from Product p where p.price > 100")
//    List<Product> myProductByPrice();
    List<Product> findByPriceBetween(int min, int max);
    Page<Product> findAll();
}
