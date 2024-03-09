package org.sid.feign;

import org.sid.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@FeignClient(name = "customer-service")
@FeignClient(url ="http://localhost:8888/CUSTOMER-SERVICE",value="customer-rest-client")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    List<Customer>listAllCustomer();
}
