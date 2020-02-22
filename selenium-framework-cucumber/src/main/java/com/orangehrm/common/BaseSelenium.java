package com.orangehrm.common;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(ImplIinvokedListner.class)
public class BaseSelenium {

	@DataProvider(name = "excelData", parallel = true)
	public String[][] getDataFromExcel(Method m) throws Exception {
		// this give excel worksheet name same as test method name
		System.out.println(m.getName());
		// this give excel workbook name same as class name
		System.out.println(m.getDeclaringClass());

		System.out.println(m.getDeclaringClass().getSimpleName());
		// file path with filename, worksheet name
		return ExcelReader.getExcelTableArray(getClassFilePath(m.getDeclaringClass()), m.getName());
	}

	// method to get file path, to be used within same package therefore
	// protected
	// ? means any class name
	protected static String getClassFilePath(Class<?> cls) {
		System.out.println("******** getFilePath for class " + cls.getName());
		// getting path of class from resource
		String strSourceClassName = cls.getResource(cls.getSimpleName() + ".class").getPath();

		System.out.println("*************** resource path is " + strSourceClassName);

		// you can remove try catch only return code will do the work
		try {
			strSourceClassName = URLDecoder.decode(strSourceClassName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strSourceClassName.replace(".class", ".xlsx");
	}

	@AfterSuite
	public void afterSuit() {
		ExtentReportTestFactory.flushReport();
	}
}
