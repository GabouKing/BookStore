package com.gk.bookstore.application.usecases.bookUsecases;

import com.gk.bookstore.adapters.bookGateway.DeleteBookGateway;
import com.gk.bookstore.core.usecases.bookUsecases.DeleteBookUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookUseCaseImpl implements DeleteBookUseCase {
    private final DeleteBookGateway deleteBookGateway;

    public DeleteBookUseCaseImpl(DeleteBookGateway deleteBookGateway) {
        this.deleteBookGateway = deleteBookGateway;
    }

    @Override
    public void deleteBook(Long bookId) {
        deleteBookGateway.deleteBook(bookId);
    }
}
