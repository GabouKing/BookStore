package com.gk.bookstore.adapters.bookGateway;

import com.gk.bookstore.core.model.Book;

import java.util.List;

public interface GetBookGateway {
    Book getBook(Long bookId);
    List<Book> getBooks();
}
