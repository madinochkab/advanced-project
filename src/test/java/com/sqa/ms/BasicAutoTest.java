package com.sqa.ms;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicAutoTest {
	static WebDriver driver;

	static Logger logger = Logger.getLogger(BasicAutoTest.class);

	@BeforeClass(enabled = false, groups = "chrome")
	public static void setupChrome() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		// Thread.sleep(1000);

	}

	@BeforeClass(enabled = true, groups = "firefox")
	public static void setupFirefox() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		// Thread.sleep(1000);

	}

	@BeforeClass(enabled = false, groups = "opera")
	public static void setupOpera() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "drivers/operadriver");
		driver = new OperaDriver();
		driver.get("http://gmail.com");
		// Thread.sleep(1000);

	}

	@BeforeClass(enabled = false, groups = "safari")
	public static void setupSafari() throws InterruptedException {
		driver = new SafariDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);

	}

	@DataProvider(name = "UserAccountInfo")
	public Object[][] getData() {
		return new Object[][] { { "madinaseven123@gmail.com", "madina261184" },
				{ "madinaseven1234@gmail.com", "madina261184" }, { "madinaseven1234@gmail.com", "madina261184" } };
	}

	@Test(dataProvider = "UserAccountInfo")
	public void test(String username, String password) {
		System.out.println("basic test: U-" + username + " password " + password);
		logger.info("My information .. ");
		for (int i = 0; i < 1000; i++) {
			logger.info("INFO message " + i);
			if (i % 3 == 0) {
				logger.fatal("fatal message " + i);
			}
			logger.debug("message Debug" + i);

		}

	}
}
