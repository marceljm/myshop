package com.marceljm.shop.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.marceljm.shop.service.FilterService;
import com.marceljm.shop.util.Util;

@Service
public class FilterServiceImpl implements FilterService {

	@Override
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
			if (valueSet.contains(word))
				continue;

			if (!strValue.contains(word))
				return false;
		}
		return true;
	}

}
