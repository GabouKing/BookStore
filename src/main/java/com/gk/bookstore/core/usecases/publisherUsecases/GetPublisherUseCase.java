package com.gk.bookstore.core.usecases.publisherUsecases;

import com.gk.bookstore.core.model.Publisher;

import java.util.List;

public interface GetPublisherUseCase {
    Publisher getPublisher(Long publisherId);
    List<Publisher> getPublishers();
}
