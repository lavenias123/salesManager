package com.stewartlavenia.SalesManager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

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
		Sale sale = new Sale(31, "Chili Bowl", 2, 15.70f);
//		Sale sale = new Sale();
		dao.save(sale);
	}

	@Test
	void testGet() {
		int id = 4;
		Sale sale = dao.get(id);
		assertNotNull(sale);
	}
	
	@Test
	void testUpdate() {
		Sale sale = new Sale();
		sale.setId(20);
		sale.setItemName("Green Beans");
		sale.setQuantity(2);
		sale.setAmount(9.95f);
		
		dao.update(sale);
	}
	
	@Test
	void testDelete() {
		int id = 22;
		dao.delete(id);
	}
}
