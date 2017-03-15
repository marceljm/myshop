package com.marceljm.shop.persistence;

import java.util.List;
import java.util.Map;

import com.marceljm.shop.entity.Category;

public interface CategoryDAO {

	List<Category> getCategoryList();

	Map<String, String> getLinkCategoryMap();

}
