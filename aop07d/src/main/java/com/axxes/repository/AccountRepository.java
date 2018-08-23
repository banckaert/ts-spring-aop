package com.axxes.repository;

import org.springframework.stereotype.Repository;

import com.axxes.domain.Account;

@Repository
public class AccountRepository {

	public Account getAccount(int id) {
		if (id==42) {
			return new Account("Eberhard","Wolff",42);
		} else {
			return new Account("Juergen","Hoeller",id);
		}
	}

}
