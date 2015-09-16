package com.capgemini.bookService.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.bookService.AbstractPageObject;

public class AddAuthorModalDialog extends AbstractPageObject {
	@FindBy(xpath = "//*[@class=\"modal-body\"]/div/div/input")
	private WebElement firstName;
	@FindBy(xpath = "//*[@class=\"modal-body\"]/div[2]/div/input")
	private WebElement lastName;
	@FindBy(xpath = "//*[@class=\"modal-footer\"]/button")
	private WebElement addButton;
	@FindBy(xpath = "//*[@class=\"modal-footer\"]/button[2]")
	private WebElement cancelButton;
	@FindBy(xpath = "//*[@class=\"modal-header\"]/div")
	private WebElement flash;

	public AddAuthorModalDialog(WebDriver driver) {
		super(driver);
	}

	public AddAuthorModalDialog setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
		return this;
	}

	public AddAuthorModalDialog setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}

	public AddBookPage clickAddButton() {
		addButton.click();
		return PageFactory.initElements(driver, AddBookPage.class);
	}

	public AddBookPage clickCancelButton() {
		cancelButton.click();
		return PageFactory.initElements(driver, AddBookPage.class);
	}

	public boolean isFlashDisplayed() {
		return flash.isDisplayed();
	}

	public String getFlashMessageText() {
		return flash.getText();
	}
}
