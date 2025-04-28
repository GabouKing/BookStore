package com.gk.bookstore.application.usecases.publisherUsecases;

import com.gk.bookstore.adapters.publisherGateway.CreatePublisherGateway;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.core.usecases.publisherUsecases.CreatePublisherUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreatePublisherUseCaseImpl implements CreatePublisherUseCase {
    private final CreatePublisherGateway createPublisherGateway;

    public CreatePublisherUseCaseImpl(CreatePublisherGateway createPublisherGateway) {
        this.createPublisherGateway = createPublisherGateway;
    }

    @Override
    public Publisher createPublisher(Publisher book) {
        return createPublisherGateway.createPublisher(book);
    }
}
