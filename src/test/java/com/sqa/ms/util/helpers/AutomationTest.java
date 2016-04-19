package com.sqa.ms.util.helpers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AutomationTest {
	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
				new Object[] { "http://amazon.com",
						"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs &amp; more" },
				new Object[] { "www.yahoo.com", "Yahoo" }, };
	}

	@Test(dataProvider = "dp")
	public void f(String url, String expectedPageTitle) {
		boolean result = Automation.checkPageTitle(url, expectedPageTitle);
		Assert.assertTrue(result);
	}
}
