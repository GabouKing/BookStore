package com.gk.bookstore.application.usecases.bookUsecases;

import com.gk.bookstore.adapters.bookGateway.GetBookGateway;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.core.usecases.bookUsecases.GetBookUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBookUseCaseImpl implements GetBookUseCase {
    private final GetBookGateway getBookGateway;

    public GetBookUseCaseImpl(GetBookGateway getBookGateway) {
        this.getBookGateway = getBookGateway;
    }

    @Override
    public Book getBook(Long bookId) {
        return getBookGateway.getBook(bookId);
    }

    @Override
    public List<Book> getBooks() {
        return getBookGateway.getBooks();
    }
}
