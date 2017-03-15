package com.marceljm.shop.persistence.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.persistence.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private String FILE = "C:\\CSV\\shop.csv";

	@Override
	public Map<String, List<Product>> categoryProductMap() {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF8"));
			String line;
			Map<String, List<Product>> categoryProductMap = new HashMap<String, List<Product>>();
			Map<String, Integer> categoryIndexMap = new HashMap<String, Integer>();
			while ((line = bf.readLine()) != null) {
				String[] field = line.split(";");
				if (categoryProductMap.get(field[7]) == null) {
					List<Product> productList = new ArrayList<Product>();
					line = line.concat(";0");
					productList.add(new Product(line));
					categoryProductMap.put(field[7], productList);
					categoryIndexMap.put(field[7], 0);
					continue;
				}
				int nextIndex = categoryIndexMap.get(field[7]) + 1;
				line = line.concat(";").concat(String.valueOf(nextIndex));
				categoryProductMap.get(field[7]).add(new Product(line));
				categoryIndexMap.put(field[7], nextIndex);
			}
			bf.close();
			return categoryProductMap;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
