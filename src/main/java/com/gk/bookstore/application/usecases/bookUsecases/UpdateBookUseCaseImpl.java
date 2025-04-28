package com.gk.bookstore.application.usecases.bookUsecases;

import com.gk.bookstore.adapters.bookGateway.UpdateBookGateway;
import com.gk.bookstore.core.dto.BookDTO;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.core.usecases.bookUsecases.UpdateBookUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookUseCaseImpl implements UpdateBookUseCase {
    private final UpdateBookGateway updateBookGateway;

    public UpdateBookUseCaseImpl(UpdateBookGateway updateBookGateway) {
        this.updateBookGateway = updateBookGateway;
    }

    @Override
    public Book updateBook(BookDTO book) {
        return updateBookGateway.updateBook(book);
    }
}
