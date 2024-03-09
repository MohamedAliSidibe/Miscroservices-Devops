package org.sid;

import org.sid.feign.CustomerServiceClient;
import org.sid.Service.ServiceCentral;
import org.sid.entities.Bill;
import org.sid.mapper.BillMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerServiceClient customerServiceClient,
										ServiceCentral serviceCentral,
										BillMapper billMapper){
		return args -> {
			/*customerServiceClient.listAllCustomer().stream()
					.forEach(e-> System.out.println(e.toString()));*/
			customerServiceClient.listAllCustomer()
					.stream()
					.forEach(e->
					{
						serviceCentral.addBillDto(
								billMapper.BilltoBillDto(
										Bill.builder()
												.customerId(e.getId())
												//.customer(e)
												.build())
						);


					});

		//productService.listProducts().forEach(e->e.toString());
		};
	}
}
