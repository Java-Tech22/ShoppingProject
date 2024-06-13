package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;

@RestController
public class ShoppingController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
		
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.findAllCustomer();
		
	}
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
		
	}
	

	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
		
	}
	
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.findProductById(id);
		
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.findCustomerById(id);
		
	}

	
	  @GetMapping("/customers/{name}") 
	  public List<Customer> getCustomerByLastName(@PathVariable String name) { 
		  return customerService.findCustomerByLastName(name);
	  }
	 
	
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable int id) {
		Product product=productService.findProductById(id);
		
		if(product !=null) {
			productService.deleteProductById(id);
			return "Product has been deleted";
		}else {
			return "Product not found ";
		}
		
		
		
	}
	

	@DeleteMapping("/customer/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		Customer customer=customerService.findCustomerById(id);
		
		if(customer !=null) {
			customerService.deleteCustomerById(id);
			return "Customer has been deleted";
		}else {
			return "Customer not found ";
		}
		
	}
	

	/*
	 * @GetMapping("/customer") 
	 * public List<Customer> getCustomerByFirstName(@RequestParam("firstName") String firstame) { 
	 * 	return customerService.findCustomerByFirstName(firstame);
	 * 
	 * }
	 */
	
	
	
	
}
