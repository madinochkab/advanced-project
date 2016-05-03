/**
 *   File Name: LoginPage.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: May 2, 2016
 *
 */

package com.sqa.ms.adactin;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * LoginPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Siebenthal, Madina
 * @version 1.0.0
 * @since 1.0
 *
 */
public class LoginPage extends DefaultPage {
	public static Logger logger = Logger.getLogger(LoginPage.class);

	@FindBy(id = "login")
	private WebElement loginBtn;
	@FindBy(id = "password")
	private WebElement passwordFld;
	@FindBy(id = "username")
	private WebElement usernameFld;
	@FindBy(how = How.CSS, using = "td.welcome_menu")
	private WebElement welcomeElement;
	// private static WebDriver driver;
	// Logger logger = Logger.getLogger(SearchPage.class);

	public LoginPage(WebDriver driver) {
		setDriver(driver);
		PageFactory.initElements(driver, this);

	}

	public LoginPage enterPassword(String password) {
		this.passwordFld.sendKeys(password);
		return this;
	}

	public LoginPage enterUsername(String username) {
		this.usernameFld.sendKeys(username);
		return this;
	}

	public SearchPage login() {
		this.loginBtn.click();
		return new SearchPage();

	}
}
