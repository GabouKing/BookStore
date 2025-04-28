package com.gk.bookstore.application.usecases.publisherUsecases;

import com.gk.bookstore.adapters.publisherGateway.UpdatePublisherGateway;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.core.usecases.publisherUsecases.UpdatePublisherUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdatePublisherUseCaseImpl implements UpdatePublisherUseCase {
    private final UpdatePublisherGateway updatePublisherGateway;

    public UpdatePublisherUseCaseImpl(UpdatePublisherGateway updatePublisherGateway) {
        this.updatePublisherGateway = updatePublisherGateway;
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return updatePublisherGateway.updatePublisher(publisher);
    }
}
