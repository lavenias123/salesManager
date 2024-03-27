package com.stewartlavenia.SalesManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
//		System.out.println(listSale);
		return listSale;
	}
	
	// insert new row
	public void save(Sale sale) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("sales").usingColumns("itemName", "quantity", "amount");
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		insertActor.execute(param);
	}

	public Sale get(int id) {
		String sql = "SELECT * FROM sales WHERE id = ?";
//		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Sale.class), id);
		Sale sale = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Sale.class), id);
		// BeanPropertyRowMapper.newInstance(Sale.class)));
		
		return sale;
	}
	
	public void update(Sale sale) {
		String sql="Update sales SET itemName=:itemName, quantity=:quantity, amount=:amount Where id = :id";
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
		
	}
	
	public void delete(int id) {
		String sql = "delete from sales where id = ?";
		jdbcTemplate.update(sql, id);
	}
	
//	public Sale get(int id) {
//		String sql = "SELECT * FROM sales WHERE id = ?";
//		//Object args = id;
//		Sale sale = jdbcTemplate.query(sql, args, new ResultSetExtractor<>());
//		
//		// BeanPropertyRowMapper.newInstance(Sale.class)));
//		return sale;
//	}
	
//	public Sale get(int id) {
//		String sql = "SELECT * FROM sales WHERE id = ?";
//		Object[] args = {id};
//		List<Map<String, Object>> sale = jdbcTemplate.queryForList(sql, args, BeanPropertyRowMapper.newInstance(Sale.class));
//		return sale;
//	}
	
//	public List<Map<String, Object>> get(int id) {
//		String sql = "SELECT * FROM sales WHERE id = ?";
//		Object[] args = {id};
//		List<Map<String, Object>> sale = jdbcTemplate.queryForList(sql, args, BeanPropertyRowMapper.newInstance(Sale.class));
//		return sale;
//	}

	
//	public void update(Sale sale) {
//		
//	}
//	
//	public void delete(int id) {
//		
//	}
}
