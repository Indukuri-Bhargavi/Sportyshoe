package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.ProductDAO;
import com.example.dao.PurchaseDAO;
import com.example.dao.UserDAO;
import com.example.model.Product;
import com.example.model.Purchase;
import com.example.model.User;

@Service
public class GeneralService {

	@Autowired
	UserDAO dao;

	public List<User> userList() {
		return dao.userList();
	}

	public String validateUser(String username, String password) {
		String status = dao.validateUser(username, password);
		return (status);
	}

	public String changePassword(String username, String newPass) {
		String status = dao.changePassword(username, newPass);
		System.out.println(status);
		return status;
	}

	@Autowired
	ProductDAO productDAO;

	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	public void addProduct(int id, String name,String category,int price)
	{
		productDAO.insertProduct(id, name,category, price);
	}
	
	public void deleteProduct(int id)
	{
		productDAO.deleteProduct(id);
	}
	@Autowired
	PurchaseDAO purchaseDao;

	public List<Purchase> getPurchaseReport() {
		return purchaseDao.purchaseReport();
	}
	
	
}
