package com.gk.bookstore.infra.gateways.bookGateway;

import com.gk.bookstore.adapters.bookGateway.CreateBookGateway;
import com.gk.bookstore.core.dto.BookDTO;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.infra.repositories.BookRepository;
import com.gk.bookstore.infra.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateBookGatewayImpl implements CreateBookGateway {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public CreateBookGatewayImpl(BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Book createBook(BookDTO book) {
        Publisher publisher = publisherRepository.findById(book.publisherId())
                .orElseThrow(() -> new IllegalArgumentException("Publisher not found") );
        Book bookEntity = new Book();
        bookEntity.setAuthor(book.author());
        bookEntity.setTitle(book.title());
        bookEntity.setPublisher(publisher);
        bookEntity.setAmount(book.amount());
        return bookRepository.save(bookEntity);
    }
}
