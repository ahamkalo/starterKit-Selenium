package com.capgemini.bookService.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.capgemini.bookService.AbstractPageObject;

public class AuthorsPage extends AbstractPageObject {
	@FindBy(xpath = "//form/div/div/input")
	private WebElement firstNamePrefix;
	@FindBy(xpath = "//form[2]/div/div/input")
	private WebElement lastNamePrefix;
	@FindBy(tagName = "table")
	private WebElement authorsTable;

	public AuthorsPage(WebDriver driver) {
		super(driver);
	}

	public AuthorsPage setFirstName(String firstNamePrefix) {
		this.firstNamePrefix.clear();
		this.firstNamePrefix.sendKeys(firstNamePrefix);
		return this;
	}

	public AuthorsPage setLastName(String lastNamePrefix) {
		this.lastNamePrefix.clear();
		this.lastNamePrefix.sendKeys(lastNamePrefix);
		return this;
	}

	public int getNumberOfAuhorsInTable() {
		try {
			int numberOfAuthors = driver.findElements(By.xpath("//tr")).size() - 1;
			return numberOfAuthors;
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
}
