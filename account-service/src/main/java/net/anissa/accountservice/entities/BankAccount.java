package net.anissa.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.anissa.accountservice.enums.AccountType;
import net.anissa.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate creatAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type; // Stocker un enumerated format String
    @Transient
    private Customer customer ; // Si on travaille dans une application mono, on aura cette declaration sans transient car Customer etait une entité
    private Long customerId;
}
