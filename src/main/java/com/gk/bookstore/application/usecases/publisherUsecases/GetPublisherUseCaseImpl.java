package com.gk.bookstore.application.usecases.publisherUsecases;

import com.gk.bookstore.adapters.publisherGateway.GetPublisherGateway;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.core.usecases.publisherUsecases.GetPublisherUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPublisherUseCaseImpl implements GetPublisherUseCase {
    private final GetPublisherGateway getPublisherGateway;

    public GetPublisherUseCaseImpl(GetPublisherGateway getPublisherGateway) {
        this.getPublisherGateway = getPublisherGateway;
    }

    @Override
    public Publisher getPublisher(Long publisherId) {
        return getPublisherGateway.getPublisher(publisherId);
    }

    @Override
    public List<Publisher> getPublishers() {
        return getPublisherGateway.getPublishers();
    }
}
