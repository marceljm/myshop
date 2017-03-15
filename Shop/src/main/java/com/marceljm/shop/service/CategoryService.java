package com.marceljm.shop.service;

import java.util.List;
import java.util.Map;

import com.marceljm.shop.entity.Category;

public interface CategoryService {

	List<Category> getCategoryList();

	Map<String, String> getLinkCategoryMap();

}
