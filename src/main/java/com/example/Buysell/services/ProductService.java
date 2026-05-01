package com.example.Buysell.services;

import org.springframework.stereotype.Service;
import com.example.Buysell.models.Product;

import java.util.List;
import java.util.ArrayList;  

@Service
public class  ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0l; 

    {
        products.add(new Product(++ID, "Midi dress", "Little black dress", 
        5000, "Moscow", "Marie"));
        products.add(new Product(++ID, "Silver ring", "Sterling silver", 
        3000, "Krasnoyarsk", "Roman"));
    }

    public List<Product> listProducts() {return products;}

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }
 
    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        };
        return null;
    }
}
