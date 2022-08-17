package com.crm.qa.utils;

import com.crm.qa.base.Base;

public class TestUtils extends Base {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
}
