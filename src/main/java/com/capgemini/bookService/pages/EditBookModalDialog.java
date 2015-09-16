package com.capgemini.bookService.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.bookService.AbstractPageObject;

public class EditBookModalDialog extends AbstractPageObject {
	@FindBy(xpath = "//*[@class=\"modal-body\"]/div/div/input")
	private WebElement title;
	@FindBy(xpath = "//*[@class=\"modal-footer\"]/button")
	private WebElement changeButton;
	@FindBy(xpath = "//*[@class=\"modal-footer\"]/button[2]")
	private WebElement cancelButton;
	@FindBy(xpath = "//*[@class=\"modal-header\"]/div")
	private WebElement flash;

	public EditBookModalDialog(WebDriver driver) {
		super(driver);
	}

	public EditBookModalDialog setTitle(String title) {
		this.title.sendKeys(title);
		return this;
	}

	public BookListPage clickChangeButton() {
		changeButton.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}

	public BookListPage clickCancelButton() {
		cancelButton.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}

	public boolean isFlashDisplayed() {
		return flash.isDisplayed();
	}

	public String getFlashMessageText() {
		return flash.getText();
	}
}
