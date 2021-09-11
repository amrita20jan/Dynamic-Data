package com.dynamic.data.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CommonValidator {

	public static boolean checkIfEmpty(List<?> list) {
		if (list != null && !list.isEmpty())
			return false;
		return true;
	}

	public static boolean isEmpty(List<?> list) {
		if (list != null && !list.isEmpty())
			return false;
		return true;
	}

	public static boolean isEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String string) {
		if (string == null || string.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNullorZero(Integer i) {
		return 0 == (i == null ? 0 : i);
	}

	public static boolean isBlank(String value) {
		if (value == null || value.toString().trim().equals(""))
			return true;
		return false;
	}

}
