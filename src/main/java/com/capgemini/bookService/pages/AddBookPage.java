package com.capgemini.bookService.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.bookService.AbstractPageObject;

public class AddBookPage extends AbstractPageObject {
	@FindBy(xpath = "//form/div/input")
	private WebElement title;
	@FindBy(xpath = "//form/div/button")
	private WebElement addBookButton;
	@FindBy(xpath = "//form/div/button[2]")
	private WebElement addAuthorButton;
	@FindBy(xpath = "//div[contains(@role,'alert')]")
	private WebElement flash;
	@FindBy(xpath = "//table")
	private WebElement authorsTable;

	public AddBookPage(WebDriver driver) {
		super(driver);
	}

	public AddBookPage clickAddBookButton() {
		addBookButton.click();
		return this;
	}

	public AddAuthorModalDialog clickAddAuthorButton() {
		addAuthorButton.click();
		return PageFactory.initElements(driver, AddAuthorModalDialog.class);
	}

	public boolean isFlashDisplayed() {
		return flash.isDisplayed();
	}

	public String getFlashMessageText() {
		return flash.getText();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isAuthorsTableEmpty() {
		return authorsTable.findElements(By.tagName("td")).isEmpty();
	}

	public AddBookPage setTitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
		return this;
	}

	public AddBookPage clickDeleteAuthor() {
		WebElement deleteAuthor = driver.findElement(By.xpath("//button [contains(text(),'Usuń autora') ]"));
		deleteAuthor.click();
		return this;
	}
}
