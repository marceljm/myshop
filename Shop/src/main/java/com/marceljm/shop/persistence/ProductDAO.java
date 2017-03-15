package com.marceljm.shop.persistence;

import java.util.List;
import java.util.Map;

import com.marceljm.shop.entity.Product;

public interface ProductDAO {

	Map<String, List<Product>> categoryProductMap();

}
