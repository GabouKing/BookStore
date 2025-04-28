package com.gk.bookstore.adapters.publisherGateway;

import com.gk.bookstore.core.model.Publisher;

import java.util.List;

public interface GetPublisherGateway {
    Publisher getPublisher(Long publisherId);
    List<Publisher> getPublishers();
}
