package com.sidhardh.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidhardh.springdemo.dao.CustomerDAO;
import com.sidhardh.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
		
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}


	@Override
	@Transactional
	public List<Customer> searchCustomer(String searchName) {
		// TODO Auto-generated method stub
		List<Customer> customers=customerDAO.searchCustomer(searchName);
		System.out.println("Service"+customers);
		return customers;
		
	}

}
