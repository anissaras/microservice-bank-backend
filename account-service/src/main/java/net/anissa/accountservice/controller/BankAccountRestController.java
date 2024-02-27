package net.anissa.accountservice.controller;

import net.anissa.accountservice.clients.CustomerRestClient;
import net.anissa.accountservice.entities.BankAccount;
import net.anissa.accountservice.model.Customer;
import net.anissa.accountservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        bankAccountList.forEach( b-> {
            b.setCustomer(customerRestClient.findCustomerById(b.getCustomerId()));
        });
        return bankAccountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String  id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
