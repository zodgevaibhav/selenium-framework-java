package com.suite.commons;

import java.lang.reflect.Method;

import com.suite.commons.library.ExcelReader;


public class TestDataProvider {
	private static String DataArray[][]=null;
	public static String[][] GetExcelDataProvider(Method m){
		try {
			DataArray = ExcelReader.getExcelTableArray(JavaUtils.getClassFilePath(m.getDeclaringClass()),m.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DataArray;
	}
}