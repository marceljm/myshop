package com.marceljm.shop.util;

import java.text.Normalizer;

public class Util {

	private static String normalize(String text) {
		return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	private static String alphaNumeric(String text) {
		return text.replaceAll("[^A-Za-z0-9]", " ").trim();
	}

	private static String removeDoubleHyphen(String text) {
		while (text.contains("--"))
			text = text.replace("--", "-");
		return text;
	}

	public static String linkfy(String text) {
		text = text.toLowerCase().trim();
		text = normalize(text);
		text = alphaNumeric(text);
		text = text.replace(" ", "-");
		return removeDoubleHyphen(text);
	}
}
