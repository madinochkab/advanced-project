/**
 *   File Name: SearchPage.java<br>
 *
 *   Siebenthal, Madina<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: May 2, 2016
 *
 */

package com.sqa.ms.adactin;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sqa.ms.util.helpers.AutoBasics;
import com.sqa.ms.util.helpers.AutoBasicsNotInitializedException;

/**
 * SearchPage //ADDD (description of class)
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
public class SearchPage extends DefaultPage {

	public static Logger logger = Logger.getLogger(SearchPage.class);

	@FindBy(id = "adult_room")
	private Select adultsPerRoom;
	@FindBy(id = "datepick_in")
	private WebElement checkIn;
	@FindBy(id = "datepick_out")
	private WebElement checkOut;
	@FindBy(id = "child_room")
	private Select childPerRoom;
	@FindBy(id = "checkout_span")
	private WebElement errorMEsCheckOut;
	@FindBy(id = "checkin_span")
	private WebElement errorMesChekIn;

	@FindBy(id = "hotels")
	private Select hotels;
	@FindBy(id = "location")
	private Select location;
	@FindBy(id = "login")
	private WebElement loginBtn;
	@FindBy(id = "room_nos")
	private Select numOfRooms;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "Reset")
	private WebElement resetBtn;
	@FindBy(id = "room_type")
	private Select roomType;
	@FindBy(id = "Submit")
	private WebElement submitBtn;
	@FindBy(id = "username_show")
	private WebElement successLogin;
	@FindBy(id = "username")
	private WebElement username;

	public SearchPage() {
		PageFactory.initElements(getDriver(), SearchPage.class);
	}

	public SearchPage chooseHotel(String hotelChoice) {
		this.location.selectByValue(hotelChoice);
		return this;
	}

	public SearchPage chooseLocation(String locationChoice) {
		this.location.selectByValue(locationChoice);
		return this;
	}

	public SearchPage chooseNumOfChildren(String childPerRoom) {
		this.childPerRoom.selectByValue(childPerRoom);
		return this;
	}

	public SearchPage chooseNumOfRooms(String numRooms) {
		this.numOfRooms.selectByValue(numRooms);
		return this;
	}

	public SearchPage chooseRoomType(String roomType) {
		this.roomType.selectByValue(roomType);
		return this;
	}

	public boolean hasWelcomeMsg() {
		// return AutoBasics.isElementPresent(driver,
		// By.cssSelector("td.welcome_menu"));
		try {
			AutoBasics.isElementPresent(getDriver(), By.cssSelector("td.welcome_menu"));
			// new AutoBasics(driver);
			return AutoBasics.isElementPresent(By.cssSelector("td.welcome_menu"));
		} catch (AutoBasicsNotInitializedException e) {
			// TODO Auto-generated catch block
			logger.warn(e.getMessage() + getClass().getEnclosingMethod());
			return false;
		}
	}

}
