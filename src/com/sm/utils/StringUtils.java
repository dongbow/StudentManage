package com.sm.utils;

public class StringUtils {

	public static boolean isNotBlank(String str) {
		if(str != null || !"".equals(str))
			return true;
		return false;
	}
	
}
