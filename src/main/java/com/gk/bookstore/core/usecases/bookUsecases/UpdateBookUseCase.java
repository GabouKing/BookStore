package com.gk.bookstore.core.usecases.bookUsecases;

import com.gk.bookstore.core.dto.BookDTO;
import com.gk.bookstore.core.model.Book;

public interface UpdateBookUseCase {
    Book updateBook(BookDTO book);
}
