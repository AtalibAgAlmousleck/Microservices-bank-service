package com.atalibdev.accountservice;

import com.atalibdev.accountservice.clients.CustomerRestClient;
import com.atalibdev.accountservice.entity.BankAccount;
import com.atalibdev.accountservice.enums.AccountType;
import com.atalibdev.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AccountRepository accountRepository,
							 CustomerRestClient customerRestClient) {
		return args -> {
			customerRestClient.allCustomers().forEach(c -> {
				BankAccount bankAccount = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("DEV")
						.balance(Math.random() * 8000)
						.createdAt(LocalDateTime.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();

				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAV")
						.balance(Math.random() * 3490)
						.createdAt(LocalDateTime.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();
				accountRepository.save(bankAccount);
				accountRepository.save(bankAccount1);
			});
		};
	}
}
