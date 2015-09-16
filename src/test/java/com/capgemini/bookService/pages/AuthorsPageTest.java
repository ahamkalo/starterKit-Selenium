package com.capgemini.bookService.pages;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bookService.AbstractSelenium;

public class AuthorsPageTest extends AbstractSelenium {

	private AuthorsPage authorsPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		addBookToTable();
		authorsPage = openHomePage().clickAuthorsPage();
	}

	@Test
	public void shouldFindAtLeastOneAuthorWithTypedFirstNamePrefix() {
		authorsPage.setFirstName("first");
		assertTrue(authorsPage.getNumberOfAuhorsInTable() > 0);

		openHomePage().clickBookListPage().clickLastDeleteBookButton();
	}

	@Test
	public void shouldFindAtLeastOneAuthorWithTypedLastNamePrefix() {
		authorsPage.setLastName("last");
		assertTrue(authorsPage.getNumberOfAuhorsInTable() > 0);

		openHomePage().clickBookListPage().clickLastDeleteBookButton();
	}

	@Test
	public void shouldFindAtLeastOneAuthorWithTypedFirstNameAndLastNamePrefix() {
		authorsPage.setFirstName("first");
		authorsPage.setLastName("last");
		assertTrue(authorsPage.getNumberOfAuhorsInTable() > 0);

		openHomePage().clickBookListPage().clickLastDeleteBookButton();
	}

	private void addBookToTable() {
		openHomePage().clickBookListPage().clickAddBookButton().setTitle("title").clickAddAuthorButton()
				.setFirstName("firstName").setLastName("lastName").clickAddButton().clickAddBookButton();
	}
}
