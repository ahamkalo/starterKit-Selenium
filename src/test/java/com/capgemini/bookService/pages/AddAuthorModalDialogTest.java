package com.capgemini.bookService.pages;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bookService.AbstractSelenium;

public class AddAuthorModalDialogTest extends AbstractSelenium {

	private AddAuthorModalDialog addAuthorModalDialog;

	@Before
	public void setUp() {
		super.setUp();
		addAuthorModalDialog = openHomePage().clickBookListPage().clickAddBookButton().clickAddAuthorButton();
	}

	@Test
	public final void shouldCheckIfFirstNameIsRequired() {
		addAuthorModalDialog.setFirstName("firstName").clickAddButton();

		assertTrue(addAuthorModalDialog.isFlashDisplayed());
		System.out.println(addAuthorModalDialog.getFlashMessageText());
		assertTrue(addAuthorModalDialog.getFlashMessageText().contains("Pole nazwisko nie zostało wypełnione."));
	}

	@Test
	public final void shouldCheckIfLastNameIsRequired() {
		addAuthorModalDialog.setLastName("lastName").clickAddButton();

		assertTrue(addAuthorModalDialog.isFlashDisplayed());
		System.out.println(addAuthorModalDialog.getFlashMessageText());
		assertTrue(addAuthorModalDialog.getFlashMessageText().contains("Pole imię nie zostało wypełnione."));
	}

	@Test
	public final void shouldCheckIfFirstNameAndLastNameAreRequired() {
		addAuthorModalDialog.clickAddButton();

		assertTrue(addAuthorModalDialog.isFlashDisplayed());
		System.out.println(addAuthorModalDialog.getFlashMessageText());
		assertTrue(addAuthorModalDialog.getFlashMessageText().contains("Pola imię i nazwisko nie zostały wypełnione."));
	}
}
