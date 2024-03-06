package com.stewartlavenia.SalesManager;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



class SalesDaoTest {
	private SalesDao dao;
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/salesSchema");
		datasource.setUsername("salesCRUD");
		datasource.setPassword("salesCRUD");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	
		dao = new SalesDao(new JdbcTemplate(datasource));
	}

	@AfterEach
	void tearDownAfterClass() throws Exception {
	}

	@Test
	void testList() {
		List<Sale> listSale = dao.list();
		assertFalse(listSale.isEmpty());
	}
	
	// in sale.j created // generate super class constructor
	@Test
	void testSave() {
		Sale sale = new Sale(18, "Small Fries", 2, 10.99f);
//		Sale sale = new Sale();
		dao.save(sale);
	}

}
