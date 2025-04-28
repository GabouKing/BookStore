package com.gk.bookstore.infra.gateways.bookGateway;

import com.gk.bookstore.adapters.bookGateway.UpdateBookGateway;
import com.gk.bookstore.core.dto.BookDTO;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.infra.repositories.BookRepository;
import com.gk.bookstore.infra.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookGatewayImpl implements UpdateBookGateway {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public UpdateBookGatewayImpl(BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Book updateBook(BookDTO book) {
        Book bookToUpdate = new Book();
        Publisher publisher = publisherRepository.findById(book.publisherId()).orElseThrow(()->
                new IllegalArgumentException("Publisher not found for id: " + book.publisherId()));
        bookToUpdate.setPublisher(publisher);
        bookToUpdate.setTitle(book.title());
        bookToUpdate.setAuthor(book.author());
        bookToUpdate.setId(book.id());
        bookToUpdate.setAmount(book.amount());
        return bookRepository.save(bookToUpdate);
    }
}
