package com.gk.bookstore.infra.gateways.bookGateway;

import com.gk.bookstore.adapters.bookGateway.DeleteBookGateway;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.infra.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookGatewayImpl implements DeleteBookGateway {
    private final BookRepository bookRepository;

    public DeleteBookGatewayImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new IllegalArgumentException("Book not found for id " + bookId));
        bookRepository.delete(book);
    }
}
