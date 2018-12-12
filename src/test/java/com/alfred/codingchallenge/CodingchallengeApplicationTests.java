package com.alfred.codingchallenge;

import com.alfred.codingchallenge.model.*;
import com.alfred.codingchallenge.repositories.AccountRepository;
import com.alfred.codingchallenge.repositories.CustomerRepository;
import com.alfred.codingchallenge.repositories.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodingchallengeApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	Long account1Id;
	Long primaryOwnerId;

	@Before
	public void init()
	{
		customerRepository.deleteAll();
		accountRepository.deleteAll();
		transactionRepository.deleteAll();
		Customer customer = customerRepository.save(new Customer("Mark"));
		primaryOwnerId = customer.getId();
		Account account1 = accountRepository.save(new Account(customer.getId(), 585309209, "SGSavings726", AccountType.Savings,
				new Timestamp(new Date().getTime()), CurrencyType.SGD, new BigDecimal(84327.51f)));
		account1Id = account1.getId();
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

	@Test
	public void customerRepoTests() {
		List<Customer> loadedCustomerList = customerRepository.findByName("Mark");
		assertEquals(1, loadedCustomerList.size());
		assertEquals("Mark", loadedCustomerList.get(0).getName());
	}

	@Test
	public void accountRepoTests() {
		List<Account> loadedAccountList = accountRepository.findByPrimaryOwnerId(primaryOwnerId);
		assertEquals(3, loadedAccountList.size());
		assertEquals("SGSavings726", loadedAccountList.get(0).getName());
		assertEquals("AUSavings933", loadedAccountList.get(1).getName());
		assertEquals("AUCurrent443", loadedAccountList.get(2).getName());
	}

	@Test
	public void transactionRepoTests() {
		List<Transaction> loadedTransactionList = transactionRepository.findBySourceAccountId(account1Id);
		assertEquals(2, loadedTransactionList.size());
		assertEquals("Credit", loadedTransactionList.get(0).getDescription());
		assertEquals("Debit", loadedTransactionList.get(1).getDescription());
	}
}
