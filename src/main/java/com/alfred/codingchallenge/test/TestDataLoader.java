package com.alfred.codingchallenge.test;
import com.alfred.codingchallenge.model.*;
import com.alfred.codingchallenge.repositories.AccountRepository;
import com.alfred.codingchallenge.repositories.CustomerRepository;
import com.alfred.codingchallenge.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class TestDataLoader {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @PostConstruct
    public void init() {
        Customer customer = customerRepository.save(new Customer("Alfred"));
        Account account1 = accountRepository.save(new Account(customer.getId(), 585309209, "SGSavings726", AccountType.Savings,
                new Timestamp(new Date().getTime()), CurrencyType.SGD, new BigDecimal(84327.51f)));
        Account account2 = accountRepository.save(new Account(customer.getId(), 791066619, "AUSavings933", AccountType.Savings,
                new Timestamp(new Date().getTime()), CurrencyType.AUD, new BigDecimal(88005.93)));
        Account account3 = accountRepository.save(new Account(customer.getId(), 321143048, "AUCurrent443", AccountType.Current,
                new Timestamp(new Date().getTime()), CurrencyType.AUD, new BigDecimal(38010.62)));
        transactionRepository.save(
            new Transaction(account1.getId(), account2.getId(), new Timestamp(new Date().getTime()), CurrencyType.AUD, new BigDecimal(123.23), null, TransactionType.CREDIT, "Credit"));
        transactionRepository.save(
                new Transaction(account1.getId(), account3.getId(), new Timestamp(new Date().getTime()), CurrencyType.SGD, null, new BigDecimal(1223.23), TransactionType.DEBIT, "Debit"));
        transactionRepository.save(
                new Transaction(account3.getId(), account1.getId(), new Timestamp(new Date().getTime()), CurrencyType.AUD, new BigDecimal(12.23), null, TransactionType.CREDIT, "Credit"));
    }

}
