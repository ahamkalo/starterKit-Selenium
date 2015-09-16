package com.capgemini.bookService.pages;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bookService.AbstractSelenium;

public class EditBookModalDialogTest extends AbstractSelenium {
	
	private EditBookModalDialog editBookModalDialog;
	private BookListPage bookListPage;

	@Before
	public void setUp() {
		super.setUp();
		bookListPage = openHomePage().clickBookListPage();
		addBookToTable();
		editBookModalDialog = bookListPage.clickLastEditBookButton();
	}

	@Test
	public final void shouldCheckIfTitleIsRequired() {
		editBookModalDialog.clickChangeButton();

		assertTrue(editBookModalDialog.isFlashDisplayed());
		assertTrue(editBookModalDialog.getFlashMessageText().contains("Pole tytuł nie zostało uzupełnione."));
	}

	private void addBookToTable() {
		bookListPage.clickAddBookButton().setTitle("title").clickAddAuthorButton().setFirstName("firstName")
				.setLastName("lastName").clickAddButton().clickAddBookButton();
	}
}
