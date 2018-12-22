package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.domain.Customers;
import net.skhu.domain.Orders;
import net.skhu.domain.PurchaseOrderDetails;
import net.skhu.model.Pagination2;
import net.skhu.repository.CustomerRepository;
import net.skhu.repository.PurchaseOrderDetailsRepository;

@Controller
@RequestMapping("exam")
public class API2Controller {
	
	@Autowired CustomerRepository customerRepository;
	@Autowired PurchaseOrderDetailsRepository purchaseOrderDetailsRepository;

	@RequestMapping("list5")
	public String list5(Model model) {
		List<Customers> list = customerRepository.findAll();
		model.addAttribute("list", list);
		return "customer/list5";
	}
	
	@RequestMapping("list6")
	public String list6(Model model) {
		List<PurchaseOrderDetails> list = purchaseOrderDetailsRepository.findAll();
		model.addAttribute("list", list);
		return "purchaseOrderDetails/list6";
	}
	
	@RequestMapping("list7")
	public String list7(Pagination2 pagination3, Model model) {

		List<Customers> list = customerRepository.findAll(pagination3);
		model.addAttribute("pagination3", pagination3);

		model.addAttribute("list", list);

        model.addAttribute("orderBy", customerRepository.orderBy);

        model.addAttribute("searchBy", customerRepository.searchBy);
		return "customer/list7";
	}
	
}
