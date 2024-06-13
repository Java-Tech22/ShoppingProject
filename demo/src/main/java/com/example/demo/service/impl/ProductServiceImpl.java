package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	ProductRepository repository;

	@Override
	public List<Product> getProducts() {
		Iterable<Product> products =repository.findAll();
		List<Product> list = new ArrayList<>();
		products.forEach(list::add);
		System.out.println(products.toString());
		return list;
	}

	@Override
	public Product findProductById(int id) {
		Optional<Product> product= repository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else
			return null;
	}

	@Override
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public void deleteProductById(int id) {
		repository.deleteById(id);
		
	}

	

}
