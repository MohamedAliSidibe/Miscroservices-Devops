package InventoryService.InventoryService.Web;

import InventoryService.InventoryService.entities.Product;
import InventoryService.InventoryService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvenServiceImpl implements InvenService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findByIdProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
