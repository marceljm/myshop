package com.marceljm.shop.persistence.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.persistence.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private String FILE = "C:\\CSV\\shop.csv";
	private String PRODUCT_CATEGORY_FILE = "C:\\CSV\\zupidCategoryMap.csv";

	@Override
	public Map<String, List<Product>> categoryProductMap() {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF8"));
			String line;
			Map<String, List<Product>> categoryProductMap = new HashMap<String, List<Product>>();
			Map<String, String> zupidCateoryMap = zupidCategoryMap();
			while ((line = bf.readLine()) != null) {
				String[] field = line.split("<");
				String zupid = field[1];
				String category = zupidCateoryMap.get(zupid);
				if (categoryProductMap.get(category) == null) {
					List<Product> productList = new ArrayList<Product>();
					productList.add(new Product(line, category));
					categoryProductMap.put(category, productList);
					continue;
				}
				categoryProductMap.get(category).add(new Product(line, category));
			}
			bf.close();
			sortLists(categoryProductMap);
			return categoryProductMap;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void sortLists(Map<String, List<Product>> categoryProductMap) {
		for (Map.Entry<String, List<Product>> entry : categoryProductMap.entrySet()) {
			Collections.sort(entry.getValue(), new Comparator<Product>() {
				public int compare(Product o1, Product o2) {
					if (o1.getPrice() < o2.getPrice())
						return -1;
					if (o1.getPrice() > o2.getPrice())
						return 1;
					return 0;
				}
			});
			int index = 0;
			for (Product product : entry.getValue())
				product.setIndex(String.valueOf(index++));
		}
	}

	private Map<String, String> zupidCategoryMap() {
		try {
			BufferedReader bf = new BufferedReader(
					new InputStreamReader(new FileInputStream(PRODUCT_CATEGORY_FILE), "UTF8"));
			String line;
			Map<String, String> zupidCategoryMap = new HashMap<String, String>();
			while ((line = bf.readLine()) != null) {
				String[] field = line.split(";");
				String zupid = field[0];
				String category = field[1];
				zupidCategoryMap.put(zupid, category);
			}
			bf.close();
			return zupidCategoryMap;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
