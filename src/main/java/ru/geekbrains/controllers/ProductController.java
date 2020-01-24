package ru.geekbrains.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.entities.Product;
import ru.geekbrains.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public String showProductList(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        System.out.println(productList);
        return "product-list";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String addNewProductList(Model model) {
        Product product = new Product();
        product.setTitle("new");
        product.setPrice(0);
        model.addAttribute("productAdd", product);
        return "product-add";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addNewProductList(Product product) {
        productService.save(product);
        return "redirect:/product/list";
    }

    @RequestMapping(value = "/product/price", method = RequestMethod.GET)
    public String showProductListInPrice(Model model) {
        Product product = new Product();
        model.addAttribute("productPriceList", product);
        return "product-price-list";
    }
//    @RequestMapping(value = "/product/price", method = RequestMethod.POST)
//    public String showProductListInPrice(Model model, int minPrice, int maxPrice) {
//        List<Product> productList = productService.myAwerageProduct(minPrice,maxPrice);
//        model.addAttribute("productPriceList", productList);
//        return "redirect:/product/list";
//    }

    @RequestMapping(path = "/showProductById/{minPrice}/{maxPrice}", method = RequestMethod.GET)
    public String showProductById(Model model, @PathVariable(value = "minPrice") int minPrice, @PathVariable(value = "maxPrice") int maxPrice) {
        List<Product> productList = productService.myAwerageProduct(new Integer(minPrice),new Integer(maxPrice));
        model.addAttribute("product", productList);
        return "redirect:/product/list";
    }
}
