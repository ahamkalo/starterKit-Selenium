package com.capgemini.bookService.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capgemini.bookService.AbstractPageObject;

public class HomePage extends AbstractPageObject {
	@FindBy(linkText = "Book List")
	private WebElement bookListPage;
	@FindBy(xpath = "//*[@class=\"nav navbar-nav\"]/li[2]/a")
	private WebElement authorsPage;
	@FindBy(linkText = "Dialog A")
	private WebElement dialogAPage;
	@FindBy(linkText = "Dialog B")
	private WebElement dialogBPage;
	@FindBy(linkText = "Starter KIT")
	private WebElement starterKit;

	@FindBy(linkText = "Books dialog")
	private WebElement bookListLink;
	@FindBy(xpath = "//p[2]/a")
	private WebElement authorsLink;
	@FindBy(xpath = "//p[3]/a")
	private WebElement dialogALink;
	@FindBy(xpath = "//p[4]/a")
	private WebElement dialogBLink;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://localhost:9721/workshop/");
	}

	public BookListPage clickBookListPage() {
		bookListPage.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}

	public AuthorsPage clickAuthorsPage() {
		authorsPage.click();
		return PageFactory.initElements(driver, AuthorsPage.class);
	}

	public DialogAPage clickDialogAPage() {
		dialogAPage.click();
		return PageFactory.initElements(driver, DialogAPage.class);
	}

	public DialogBPage clickDialogBPage() {
		dialogBPage.click();
		return PageFactory.initElements(driver, DialogBPage.class);
	}

	public BookListPage clickBookListLink() {
		bookListLink.click();
		return PageFactory.initElements(driver, BookListPage.class);
	}

	public AuthorsPage clickAuthorsLink() {
		authorsLink.click();
		return PageFactory.initElements(driver, AuthorsPage.class);
	}

	public DialogAPage clickDialogALink() {
		dialogALink.click();
		return PageFactory.initElements(driver, DialogAPage.class);
	}

	public DialogBPage clickDialogBLink() {
		dialogBLink.click();
		return PageFactory.initElements(driver, DialogBPage.class);
	}

	public HomePage clickStarterKitPage() {
		starterKit.click();
		return this;
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
