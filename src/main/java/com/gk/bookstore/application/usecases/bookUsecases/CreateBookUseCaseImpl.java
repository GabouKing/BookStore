package com.gk.bookstore.application.usecases.bookUsecases;

import com.gk.bookstore.adapters.bookGateway.CreateBookGateway;
import com.gk.bookstore.core.dto.BookDTO;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.core.usecases.bookUsecases.CreateBookUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateBookUseCaseImpl implements CreateBookUseCase {
    private final CreateBookGateway createBookGateway;

    public CreateBookUseCaseImpl(CreateBookGateway createBookGateway) {
        this.createBookGateway = createBookGateway;
    }

    @Override
    public Book createBook(BookDTO book) {
        return createBookGateway.createBook(book);
    }
}
