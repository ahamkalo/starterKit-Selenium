package com.capgemini.bookService.pages;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bookService.AbstractSelenium;

public class HomePageTest extends AbstractSelenium {
	
	private HomePage homePage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		homePage = openHomePage();
	}

	@Test
	public void shouldOpenHomePage() {
		homePage.clickStarterKitPage();

		assertEquals("http://localhost:9721/workshop/#/main/welcome", homePage.getCurrentUrl());
	}

	@Test
	public void shouldOpenBookListPage() {
		homePage.clickBookListPage();

		assertEquals("http://localhost:9721/workshop/#/books/book-list", homePage.getCurrentUrl());
	}

	@Test
	public void shouldOpenAuthorsPage() {
		homePage.clickAuthorsPage();

		assertEquals("http://localhost:9721/workshop/#/authors/authors", homePage.getCurrentUrl());
	}

	@Test
	public void shouldOpenDialogAPage() {
		homePage.clickDialogAPage();

		assertEquals("http://localhost:9721/workshop/#/component-1/dialog-a", homePage.getCurrentUrl());
	}

	@Test
	public void shouldOpenDialogBPage() {
		homePage.clickDialogBPage();

		assertEquals("http://localhost:9721/workshop/#/component-2/dialog-b", homePage.getCurrentUrl());
	}

	@Test
	public void shouldOpenBookListPageAfterLinkClick() {
		homePage.clickBookListLink();

		assertEquals("http://localhost:9721/workshop/#/books/book-list", homePage.getCurrentUrl());
	}

	@Test
	public void shouldOpenAuthorsPageAfterLinkClick() {
		homePage.clickAuthorsLink();

		assertEquals("http://localhost:9721/workshop/#/authors/authors", homePage.getCurrentUrl());
	}

	@Test
	public void shouldOpenDialogAPageAfterLinkClick() {
		homePage.clickDialogALink();

		assertEquals("http://localhost:9721/workshop/#/component-1/dialog-a", homePage.getCurrentUrl());
	}

	@Test
	public void shouldOpenDialogBPageAfterLinkClick() {
		homePage.clickDialogBLink();

		assertEquals("http://localhost:9721/workshop/#/component-2/dialog-b", homePage.getCurrentUrl());
	}
}
