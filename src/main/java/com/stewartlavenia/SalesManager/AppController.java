package com.stewartlavenia.SalesManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private SalesDao dao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Sale> listSale = dao.list();
		model.addAttribute("listSale", listSale);
		return "index";
	}
	
	@RequestMapping(value= "/new")
	public String showNewForm(Model model) {
//		Sale sale = new Sale();
		Sale sale = new Sale(0, null, 0, 0);
		model.addAttribute("sale", sale);
		
		return "newFormTwo";
	}
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("sale") Sale sale) {
		dao.save(sale);
		return "redirect:/";
	}
	
	@RequestMapping(value= "/edit{id}", method = RequestMethod.GET)
	public ModelAndView showEditForm(@PathVariable("id") int id) {
		// (@PathVariable(name = "id") int id)
		ModelAndView mav = new ModelAndView("edit_form");
		
		Sale sale = dao.get(id);
		
		mav.addObject("sale", sale);
		return mav;
	}
	
	@RequestMapping(value= "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("sale") Sale sale) {
		dao.update(sale);
		
		return "redirect:/";
	}
	
	@RequestMapping(value= "/delete{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		
		dao.delete(id);
		return "redirect:/";
	}
}
