package com.alfred.codingchallenge.repositories;

import com.alfred.codingchallenge.model.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "transactions", path = "transactions")
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {

	List<Transaction> findBySourceAccountId(@Param("sourceAccountId") Long sourceAccountId);
}
