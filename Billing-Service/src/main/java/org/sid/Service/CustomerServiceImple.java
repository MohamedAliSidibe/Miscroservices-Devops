package org.sid.Service;

import org.sid.Service.ServiceCentral;
import org.sid.dto.BillDto;
import org.sid.entities.Customer;
import org.sid.feign.CustomerServiceClient;
import org.sid.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billCusto")
public class CustomerServiceImple {

    @Autowired
    CustomerServiceClient customerServiceClient;
    @Autowired
    ServiceCentral serviceCentral;
    @GetMapping("/list")
    public List<Customer> customerList(){
        return customerServiceClient.listAllCustomer();
    }
    @GetMapping("/listbill")
    public  List<BillDto> customerListBill(){
        return serviceCentral.listBillDto();
    }
}
