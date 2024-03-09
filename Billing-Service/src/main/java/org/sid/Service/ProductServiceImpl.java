package org.sid.Service;


import org.sid.entities.Product;
import org.sid.feign.ProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billProd")
public class ProductServiceImpl {
    @Autowired
    ProductServiceClient productServiceImpl;

    @GetMapping("/list")
    List<Product> productList(){
        return productServiceImpl.listProducts();
    }

    @GetMapping("/prod")
    Product product(Long id) {
        return productServiceImpl.productId(id);
    }
}
