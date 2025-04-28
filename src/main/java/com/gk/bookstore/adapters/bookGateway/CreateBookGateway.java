package com.gk.bookstore.adapters.bookGateway;

import com.gk.bookstore.core.dto.BookDTO;
import com.gk.bookstore.core.model.Book;

public interface CreateBookGateway {
    Book createBook(BookDTO book);
}
