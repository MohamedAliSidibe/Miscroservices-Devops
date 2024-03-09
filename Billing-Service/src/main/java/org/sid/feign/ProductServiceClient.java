package org.sid.feign;

import org.sid.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url= "http://localhost:8888/INVENTORY-SERVICE/inven",value = "product-rest-client")
public interface ProductServiceClient {
    @GetMapping("/list")
    List<Product> listProducts();
    @GetMapping("/prod/{id}")
    Product productId(@PathVariable Long id);
}
