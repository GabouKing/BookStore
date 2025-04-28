package com.gk.bookstore.core.usecases.bookUsecases;

import com.gk.bookstore.core.model.Book;

import java.util.List;

public interface GetBookUseCase {
    Book getBook(Long bookId);
    List<Book> getBooks();
}
