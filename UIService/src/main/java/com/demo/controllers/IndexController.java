package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.demo.entities.Product;
import com.demo.repositories.ProductRepository;

@Controller
@RequestMapping(value= {"","product"})
public class IndexController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="/getAllProducts",method=RequestMethod.GET)
	public List<Product> getAllProducts(){
		List<Product> product=productRepository.findAll();
		return product;
		
		
	}

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("product",new Product());
		//System.out.print(product);
		
		return "product/index";
	}
	
	@RequestMapping(value="index",method=RequestMethod.POST)
	public String index(@ModelAttribute("product") Product product) {
		
		productRepository.save(product);
		return "redirect:/index";
	}

}
