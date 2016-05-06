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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	@FindBy(id = "adult_room")
	private WebElement adultsPerRoom;

	@FindBy(id = "datepick_in")
	private WebElement checkIn;

	@FindBy(id = "datepick_out")
	private WebElement checkOut;

	@FindBy(id = "child_room")
	private WebElement childPerRoom;

	@FindBy(id = "checkout_span")
	private WebElement errorMesCheckOut;

	@FindBy(id = "checkin_span")
	private WebElement errorMesChekIn;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "login")
	private WebElement loginBtn;

	@FindBy(id = "room_nos")
	private WebElement numOfRooms;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "Reset")
	private WebElement resetBtn;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(id = "Submit")
	private WebElement submitBtn;

	@FindBy(id = "username_show")
	private WebElement successLogin;

	@FindBy(id = "username")
	private WebElement username;

	public SearchPage() {
		PageFactory.initElements(getDriver(), SearchPage.class);
	}

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(getDriver(), this);
	}

	public SearchPage chooseCheckInDate(String date) {
		this.checkIn.clear();
		this.checkIn.sendKeys(date);
		return this;
	}

	public SearchPage chooseCheckOutDate(String date) {
		this.checkOut.clear();
		this.checkOut.sendKeys(date);
		return this;
	}

	public SearchPage chooseHotel(String hotelChoice) {
		Select selectHotels = new Select(this.hotels);
		selectHotels.selectByVisibleText(hotelChoice);
		return this;
	}

	public SearchPage chooseLocation(String locationChoice) {
		Select selectLocation = new Select(this.location);
		selectLocation.selectByVisibleText(locationChoice);
		return this;
	}

	public SearchPage chooseNumAdultsInRoom(String numInRoom) {
		Select selectAdultsPerRoom = new Select(this.adultsPerRoom);
		selectAdultsPerRoom.selectByValue(numInRoom);
		return this;
	}

	public SearchPage chooseNumChildrenInRoom(String numInRoom) {
		Select selectChildrenPerRoom = new Select(this.childPerRoom);
		selectChildrenPerRoom.selectByValue(numInRoom);
		return this;
	}

	// public SearchPage chooseNumOfChildren(String numOfChildren) {
	// Select selectNumOfChildren = new Select(this.childPerRoom);
	// selectNumOfChildren.selectByValue(numOfChildren);
	// return this;
	// }

	public SearchPage chooseNumOfRooms(String numRooms) {
		Select selectNumRooms = new Select(this.numOfRooms);
		selectNumRooms.selectByValue(numRooms);
		return this;
	}

	public SearchPage chooseRoomType(String roomType) {
		Select selectRoomType = new Select(this.roomType);
		selectRoomType.selectByVisibleText(roomType);
		return this;
	}

	public String getCheckInErrorMessage() {
		if (hasCheckInErrorMessage()) {
			return this.errorMesChekIn.getText();

		} else {
			return "";
		}
	}

	public String getCheckOutErrorMessage() {
		if (hasCheckOutErrorMessage()) {
			return this.errorMesCheckOut.getText();

		} else {
			return "";
		}
	}

	public boolean hasCheckInErrorMessage() {
		boolean hasMessage = false;
		hasMessage = AutoBasics.isElementPresent(getDriver(), By.id("checkin_span"));
		if (hasMessage) {
			if (this.errorMesChekIn.getText().length() > 1) {
				hasMessage = true;
				System.out.println("Message:" + this.errorMesChekIn.getText());
			} else {
				hasMessage = false;
			}
		}
		return hasMessage;
	}

	public boolean hasCheckOutErrorMessage() {
		boolean hasMessage = false;
		hasMessage = AutoBasics.isElementPresent(getDriver(), By.id("checkout_span"));
		if (hasMessage) {
			if (this.errorMesCheckOut.getText().length() > 1) {
				hasMessage = true;
				System.out.println("Message:" + this.errorMesCheckOut.getText());
			} else {
				hasMessage = false;
			}
		}
		return hasMessage;
	}

	public boolean hasWelcomeMsg() {
		try {
			AutoBasics.isElementPresent(getDriver(), By.cssSelector("td.welcome_menu"));
			return AutoBasics.isElementPresent(By.cssSelector("td.welcome_menu"));
		} catch (AutoBasicsNotInitializedException e) {
			// TODO Auto-generated catch block
			getLogger().warn(e.getMessage());
			return false;
		}

	}

	public SearchPage reset() {
		this.resetBtn.click();
		return this;

	}

	public SearchPage submit() {
		this.submitBtn.click();
		return this;

	}
}