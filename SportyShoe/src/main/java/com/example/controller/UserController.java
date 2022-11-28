package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.Product;
import com.example.model.Purchase;
import com.example.model.User;
import com.example.model.changePassword;
import com.example.service.GeneralService;

@Controller
public class UserController {

	@Autowired
	GeneralService service;

	@GetMapping("/LoginPage")
	public String userValidation(@ModelAttribute User user) {
		String status = service.validateUser(user.getUsername(), user.getPassword());
		if (status.equals("success"))
			return "ViewPage";
		return "LoginPage";

	}

	@GetMapping("/UserList")
	public String getUserList(Model model) {
		List<User> user = service.userList();
		model.addAttribute("userList", user);
		return "userList";
	}

	@GetMapping("/ProductList")
	public String getProducts(Model model) {
		List<Product> products = service.getProducts();
		model.addAttribute("productList", products);

		// STEP 4: Invoke view

		return "ProductList";
	}

	@GetMapping("/PurchaseReport")
	public String getPurchaseReport(Model model) {
		List<Purchase> purchase = service.getPurchaseReport();
		model.addAttribute("purchaseReport", purchase);

		return "PurchaseReport";
	}

	@GetMapping("/ChangePassword")
	public String changePassword(@ModelAttribute changePassword ch, Model model) {
		service.changePassword(ch.getUsername(), ch.getNewPassword());
		model.addAttribute("Message", "Password changed Successfully");
		try {
			return "ChangePassword";
		} finally {
			return "ChangeSuccess";
		}
	}
	
	@GetMapping("/AddProduct")
	public String addProduct(@ModelAttribute Product product)
	{
		int productNumber = product.getProductNumber();
		String productName = product.getProductName();
		String productCategory= product.getProductCategory();
		int productPrice = product.getProductPrice();
		service.addProduct(productNumber,productName,productCategory,productPrice);
		return "AddProduct";
	}

	@GetMapping("/DeleteProduct")
	public String deleteProduct(@ModelAttribute Product product, Model model)
	{
		int productNumber = product.getProductNumber();
		service.deleteProduct(productNumber);
		model.addAttribute("Message", "Deleted Successfully");
		try {
			return "DeleteProduct";
		}
		finally
		{
			return "DeleteSuccess";
		}
	}
}
