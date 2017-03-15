package com.marceljm.shop.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.persistence.impl.ProductDAOImpl;
import com.marceljm.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductDAOImpl productDAO;

	@Override
	public Map<String, List<Product>> getCategoryProductMap() {
		return productDAO.categoryProductMap();
	}

	@Override
	public String getLink(String main, String sub, String third) {
		String link = main.concat("/").concat(sub);
		return third.isEmpty() ? link : link.concat("/").concat(third);
	}

}
