package com.alfred.codingchallenge.repositories;

import com.alfred.codingchallenge.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

	List<Account> findByPrimaryOwnerId(@Param("primaryOwnerId") Long primaryOwnerId);
}
