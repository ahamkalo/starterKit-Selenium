package com.capgemini.bookService.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.bookService.AbstractPageObject;

public class BookListPage extends AbstractPageObject {
	@FindBy(xpath = "//input")
	private WebElement titlePrefix;
	@FindBy(xpath = "//button [contains(text(),'Szukaj') ]")
	private WebElement searchButton;
	@FindBy(xpath = "//button[2]")
	private WebElement addBookButton;
	@FindBy(css = ".booklist")
	private WebElement booksTable;

	public BookListPage(WebDriver driver) {
		super(driver);
	}

	public BookListPage setTitle(String titlePrefix) {
		this.titlePrefix.clear();
		this.titlePrefix.sendKeys(titlePrefix);
		return this;
	}

	public BookListPage clickSearchButton() {
		searchButton.click();
		return this;
	}

	public AddBookPage clickAddBookButton() {
		addBookButton.click();
		return PageFactory.initElements(driver, AddBookPage.class);
	}

	public BookListPage clickLastDeleteBookButton() {
		List<WebElement> deleteBookButtons = driver.findElements(By.xpath("//button [text()='Usuń' ]"));
		deleteBookButtons.get(deleteBookButtons.size() - 1).click();
		return this;
	}

	public EditBookModalDialog clickLastEditBookButton() {
		List<WebElement> editBookButtons = driver.findElements(By.xpath("//button [text()='Edytuj' ]"));
		editBookButtons.get(editBookButtons.size() - 1).click();
		return PageFactory.initElements(driver, EditBookModalDialog.class);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public int getNumberOfBooksInTable() {
		try {
			int numberOfBooks = driver.findElements(By.xpath("//tr")).size() - 1;
			return numberOfBooks;
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
}
