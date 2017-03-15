package com.marceljm.shop.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.marceljm.shop.entity.Product;

@Controller
@Scope("session")
public class FilterController {

	private List<Product> filteredList;

	public List<Product> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Product> filteredList) {
		this.filteredList = filteredList;
	}

}
