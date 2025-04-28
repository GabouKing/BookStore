package com.gk.bookstore.infra.gateways.bookGateway;

import com.gk.bookstore.adapters.bookGateway.GetBookGateway;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.infra.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetBookGatewayImpl implements GetBookGateway {
    private final BookRepository bookRepository;

    public GetBookGatewayImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() ->
                new IllegalArgumentException("Book not found"));
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
