package com.marceljm.shop.service;

import java.util.List;
import java.util.Map;

import com.marceljm.shop.entity.Product;

public interface ProductService {

	Map<String, List<Product>> getCategoryProductMap();

}
