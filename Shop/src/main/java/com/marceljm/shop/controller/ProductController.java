package com.marceljm.shop.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.service.impl.CategoryServiceImpl;
import com.marceljm.shop.service.impl.ProductServiceImpl;

@Controller
@Scope("singleton")
public class ProductController {

	@Inject
	private ProductServiceImpl productService;

	@Inject
	private CategoryServiceImpl categoryService;

	private Map<String, List<Product>> categoryProductMap;

	@PostConstruct
	public void init() {
		categoryProductMap = productService.getCategoryProductMap();
	}

	public List<Product> productList(String link) {
		String category = categoryService.getLinkCategoryMap().get(link);
		return categoryProductMap.get(category);
	}

}
