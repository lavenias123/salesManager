package com.stewartlavenia.SalesManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class SalesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public SalesDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Sale> list() {
		String sql = "SELECT * FROM sales";
		
		// represents DB info without result set?
		List<Sale> listSale = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sale.class));
		return listSale;
	}
	
	// insert new row
	public void save(Sale sale) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("sales").usingColumns("itemName", "quantity", "amount");
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		insertActor.execute(param);
	}
	
//	public Sale get(int id) {
//		return null;
//	}
//	
//	public void update(Sale sale) {
//		
//	}
//	
//	public void delete(int id) {
//		
//	}
}
