package com.sidhardh.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sidhardh.springdemo.entity.Customer;
import com.sidhardh.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject Service-customer
	@Autowired
	private CustomerService customerService;
	
	
	 
	
	
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		//get customers from customerService
		
		List<Customer> theCustomers=customerService.getCustomers();
		//add customers into model
		
		model.addAttribute("customers",theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		//get customers from customerService
		
		Customer theCustomer= new Customer();
		model.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		System.out.println("Log : Customer- Controller "+theCustomer);
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("customerId") int theId ,Model theModel)
	{
		//get Customer from service
		
		//set as Model for update Page
		
		//send to form
		
		Customer theCustomer=	customerService.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
		
	}
	
	@GetMapping("/search")
	public String searchCustomer(@ModelAttribute("theSearchName") String searchName,Model theModel)
	{
		
		System.out.println(searchName);
		
		List<Customer> customers= customerService.searchCustomer(searchName);
		theModel.addAttribute("customers",customers);
		System.out.println("controller"+customers);
		return "list-customer";
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(@ModelAttribute("customerId") int theId)
	{
		//delete customer
		customerService.deleteCustomer(theId);
				
		return "redirect:/customer/list";
	}
	
	
}
