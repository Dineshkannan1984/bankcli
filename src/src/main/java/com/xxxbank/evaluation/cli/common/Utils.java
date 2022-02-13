package com.xxxbank.evaluation.cli.common;

import java.util.List;

public class Utils {

	public static boolean isEmpty(String val) {
		return (null == val || val.trim().isEmpty());
	}

	public static <T> boolean isEmpty(List<T> val) {
		return (null == val || val.isEmpty());
	}

	public static String cleanString(String val) {
		if (isEmpty(val)) {
			return null;
		}
		return val.trim();
	}
}
