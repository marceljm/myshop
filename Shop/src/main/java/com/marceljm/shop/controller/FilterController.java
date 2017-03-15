package com.marceljm.shop.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.util.Util;

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

	public boolean customFilter(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();

		if (filterText == null || filterText.equals(""))
			return true;

		if (value == null)
			return false;

		String strValue = Util.simplify((String) value);
		String strFilter = Util.simplify((String) filter);

		String[] filterArray = strFilter.split(" ");
		Set<String> valueSet = new HashSet<String>(Arrays.asList(strValue.split(" ")));

		for (String word : filterArray) {
			if (!valueSet.contains(word))
				return false;
		}
		return true;
	}
}
