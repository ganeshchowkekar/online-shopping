package com.gpc.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gpc.onlineshopping.dao.CategoryDAO;
import com.gpc.onlineshopping.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO; 

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClicksHome", true);

		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClicksAbout", true);

		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClicksContact", true);

		return mv;
	}
	
	/**
	 * 
	 methods to load all the products and  based on category
	 **/
	@RequestMapping(value = "show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClicksAllProducts", true);

		return mv;
	}

	
	
	@RequestMapping(value = "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int  id) {
		ModelAndView mv = new ModelAndView("page");
		
		Category category=null;
		category=categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClicksCategoryProducts", true);

		return mv;
	}
	
}
