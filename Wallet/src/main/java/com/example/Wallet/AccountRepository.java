package com.example.Wallet;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	/*
	 * private final JdbcTemplate jdbc;
	 * 
	 * public AccountRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }
	 * 
	 * public Account findAccountById(long id) { String sql =
	 * "SELECT * FROM account WHERE id = ?"; return jdbc.queryForObject(sql, new
	 * AccountRowMapper(), id); }
	 * 
	 * public List<Account> findAllAccounts(){ String sql = "SELECT * FROM account";
	 * return jdbc.query(sql, new AccountRowMapper()); }
	 * 
	 * public void changeAmount(long id, BigDecimal amount) { String sql =
	 * "UPDATE account SET amount = ? WHERE id = ?"; jdbc.update(sql, amount, id); }
	 */
	@Query("SELECT * FROM account WHERE name = :name")
	List<Account> findAccountsByName(String name);
	
	@Modifying
	@Query("UPDATE account SET amount = :amount WHERE id = :id")
	void changeAmount(long id, BigDecimal amount);
	
	
}
