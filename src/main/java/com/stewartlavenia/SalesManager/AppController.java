package com.stewartlavenia.SalesManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@Autowired
	private SalesDao salesDao;
	
	@RequestMapping(value= "/home")
	public String viewHomePage(Model model) {
		List<Sale> listSale = salesDao.list();
		model.addAttribute("listSale", listSale);
		return "home";
	}
	
	@RequestMapping(value= "/new")
	public String showNewForm(Model model) {
//		Sale sale = new Sale();
		Sale sale = new Sale(0, null, 0, 0);
		model.addAttribute("sale", sale);
		
		return "newFormTwo";
	}
}
