package com.capgemini.bookService.pages;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.capgemini.bookService.AbstractSelenium;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// don't change it in order to avoid changing database
public class BookListPageTest extends AbstractSelenium {

	private BookListPage bookListPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		bookListPage = openHomePage().clickBookListPage();
	}

	@Test
	public void shouldAddNewBook() {
		int numberOfBooksInTable = bookListPage.getNumberOfBooksInTable();
		addBookToTable("title");
		assertEquals(numberOfBooksInTable + 1, bookListPage.getNumberOfBooksInTable());
	}

	@Test
	public void shouldDismissEditingBookOnCancelButtonClick() {
		bookListPage.setTitle("title");
		bookListPage.clickSearchButton();
		int numberOfBooksInTable = bookListPage.getNumberOfBooksInTable();

		bookListPage.clickLastEditBookButton().clickCancelButton();

		bookListPage.clickSearchButton();

		assertEquals(numberOfBooksInTable, bookListPage.getNumberOfBooksInTable());
		assertEquals("http://localhost:9721/workshop/#/books/book-list", bookListPage.getCurrentUrl());
	}

	@Test
	public void shouldEditLastAddedBook() {
		bookListPage.clickLastEditBookButton().setTitle("changedTitle").clickChangeButton();

		bookListPage.setTitle("changedTitle");
		bookListPage.clickSearchButton();

		assertTrue(bookListPage.getNumberOfBooksInTable() > 0);
		assertEquals("http://localhost:9721/workshop/#/books/book-list", bookListPage.getCurrentUrl());
	}

	@Test
	public void shouldFindOneBook() {
		addBookToTable("title2");
		bookListPage.setTitle("title2");
		bookListPage.clickSearchButton();

		assertEquals(1, bookListPage.getNumberOfBooksInTable());
	}

	@Test
	public void shouldLastTwoAddedBookDelete() {
		bookListPage.setTitle("");
		bookListPage.clickSearchButton();
		int numberOfBooksInTable = bookListPage.getNumberOfBooksInTable();
		bookListPage.clickLastDeleteBookButton();
		bookListPage.clickLastDeleteBookButton();
		assertEquals(numberOfBooksInTable - 2, bookListPage.getNumberOfBooksInTable());
	}

	@Test
	public void shouldOpenAddBookPage() {
		bookListPage.clickAddBookButton();
		assertEquals("http://localhost:9721/workshop/#/books/add-book", bookListPage.getCurrentUrl());
	}

	private void addBookToTable(String title) {
		bookListPage.clickAddBookButton().setTitle(title).clickAddAuthorButton().setFirstName("firstName")
				.setLastName("lastName").clickAddButton().clickAddBookButton();
	}
}
