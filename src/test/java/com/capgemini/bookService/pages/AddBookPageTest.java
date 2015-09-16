package com.capgemini.bookService.pages;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bookService.AbstractSelenium;

public class AddBookPageTest extends AbstractSelenium {

	private AddBookPage addBookPage;

	@Before
	public void setUp() {
		super.setUp();
		addBookPage = openHomePage().clickBookListPage().clickAddBookButton();
	}

	@Test
	public final void shouldCheckIfTitleIsRequired() {
		addBookPage.clickAddAuthorButton().setFirstName("firstName").setLastName("lastName").clickAddButton();

		addBookPage.clickAddBookButton();

		assertTrue(addBookPage.isFlashDisplayed());
		assertTrue(addBookPage.getFlashMessageText().contains("Nie został wpisany tytuł książki."));
		assertEquals("http://localhost:9721/workshop/#/books/add-book", addBookPage.getCurrentUrl());
	}

	@Test
	public final void shouldCheckIfAtLeastOneAuthorIsRequired() {
		addBookPage.setTitle("title");

		addBookPage.clickAddBookButton();

		assertTrue(addBookPage.isFlashDisplayed());
		assertTrue(addBookPage.getFlashMessageText().contains("Nie został dodany żaden autor książki."));
		assertEquals("http://localhost:9721/workshop/#/books/add-book", addBookPage.getCurrentUrl());
	}

	@Test
	public final void shouldCheckIfTitleAndAtLeastOneAuthorAreRequired() {
		addBookPage.clickAddBookButton();

		assertTrue(addBookPage.isFlashDisplayed());
		assertTrue(addBookPage.getFlashMessageText()
				.contains("Nie został wpisany tytuł książki i nie dodano żadnego autora."));
		assertEquals("http://localhost:9721/workshop/#/books/add-book", addBookPage.getCurrentUrl());
	}

	@Test
	public final void shouldAddAuthorToTable() {
		assertTrue(addBookPage.isAuthorsTableEmpty());

		addBookPage.clickAddAuthorButton().setFirstName("firstName").setLastName("lastName").clickAddButton();

		assertFalse(addBookPage.isAuthorsTableEmpty());
		assertTrue(addBookPage.isFlashDisplayed());
		assertTrue(addBookPage.getFlashMessageText().contains("Autor został dodany."));
		assertEquals("http://localhost:9721/workshop/#/books/add-book", addBookPage.getCurrentUrl());
	}

	@Test
	public final void shouldDeleteAuthorFromTable() {
		assertTrue(addBookPage.isAuthorsTableEmpty());

		addBookPage.clickAddAuthorButton().setFirstName("firstName").setLastName("lastName").clickAddButton();

		assertFalse(addBookPage.isAuthorsTableEmpty());

		addBookPage.clickDeleteAuthor();

		assertTrue(addBookPage.isAuthorsTableEmpty());
		assertTrue(addBookPage.isFlashDisplayed());
		assertTrue(addBookPage.getFlashMessageText().contains("Autor został usunięty."));
		assertEquals("http://localhost:9721/workshop/#/books/add-book", addBookPage.getCurrentUrl());
	}

	@Test
	public final void shouldDismissAddingAuthorOnCancelButtonClick() {
		assertTrue(addBookPage.isAuthorsTableEmpty());

		addBookPage.clickAddAuthorButton().setFirstName("firstName").setLastName("lastName").clickCancelButton();

		assertTrue(addBookPage.isAuthorsTableEmpty());
		assertTrue(addBookPage.isFlashDisplayed());
		assertTrue(addBookPage.getFlashMessageText().contains("Wyjątek"));
		assertEquals("http://localhost:9721/workshop/#/books/add-book", addBookPage.getCurrentUrl());
	}
}
