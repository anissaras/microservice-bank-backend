package net.anissa.customerservice;

import net.anissa.customerservice.entities.Customer;
import net.anissa.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);

    }

    /*@Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("anissa1")
                            .lastName("ras1")
                            .email("anissa1@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("anissa2")
                            .lastName("ras2")
                            .email("anissa2@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("anissa3")
                            .lastName("ras3")
                            .email("anissa3@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };

    }*/
}
