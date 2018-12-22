package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Customers;
import net.skhu.domain.Employees;
import net.skhu.domain.OrderDetails;
import net.skhu.domain.Orders;
import net.skhu.domain.Products;
import net.skhu.model.Pagination;
import net.skhu.model.Pagination2;
import net.skhu.repository.CustomerRepository;
import net.skhu.repository.EmployeesRepository;
import net.skhu.repository.OredersRepository;
import net.skhu.repository.OredersRepository2;
import net.skhu.repository.ProductsRepository;

@RestController
@RequestMapping("api")
public class APIController {
	
	@Autowired EmployeesRepository employeesRepository;
	@Autowired OredersRepository ordersRepository;
	@Autowired OredersRepository2 ordersRepository2;
	@Autowired ProductsRepository productsRepository;
	@Autowired CustomerRepository customerRepository;
	
	@RequestMapping("order/{id}/products")
	public List<Products> products(@PathVariable("id") int id) {
		List<OrderDetails> list = ordersRepository.findById(id).get().getOrderDetails();
		List<Products> list2 = new ArrayList<Products>();
		for(OrderDetails o : list)
			list2.add(o.getProducts());
		return list2;
	}
	
	@RequestMapping("customers")
	public List<Customers> customers() {
		List<Customers> list = customerRepository.findAll();
		return list;
	}
	

}
