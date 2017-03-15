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
import com.marceljm.shop.util.Util;

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

	public List<Product> productList(String main, String sub, String third) {
		String link = productService.getLink(main, sub, third);
		String category = categoryService.getLinkCategoryMap().get(link);
		return categoryProductMap.get(category);
	}

	public String linkfy(String name, String category, String index) {
		return Util.linkfy(name).concat("/").concat(category).concat("/").concat(index);
	}

}
