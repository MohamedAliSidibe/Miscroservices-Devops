package InventoryService.InventoryService.Web;

import InventoryService.InventoryService.entities.Product;
import InventoryService.InventoryService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/inven")
public interface InvenService {
    @GetMapping("list")
    List<Product>listProduct();
    @GetMapping("/prod/{id}")
    Product findByIdProduct(@PathVariable Long id);
}
