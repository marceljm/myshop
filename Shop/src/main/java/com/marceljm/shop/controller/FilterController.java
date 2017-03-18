package com.marceljm.shop.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.service.FilterService;

@Controller
@Scope("session")
public class FilterController {

	@Inject
	private FilterService filterService;

	private List<Product> filteredList;

	public List<Product> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Product> filteredList) {
		this.filteredList = filteredList;
	}

	public boolean customFilter(Object value, Object filter, Locale locale) {
		return filterService.customFilter(value, filter, locale);
	}

	public void reset() {
		filteredList = null;
	}
}
