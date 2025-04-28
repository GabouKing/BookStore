package com.gk.bookstore.application.usecases.publisherUsecases;

import com.gk.bookstore.adapters.publisherGateway.DeletePublisherGateway;
import com.gk.bookstore.core.usecases.publisherUsecases.DeletePublisherUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeletePublisherUseCaseImpl implements DeletePublisherUseCase {
    private final DeletePublisherGateway deletePublisherGateway;

    public DeletePublisherUseCaseImpl(DeletePublisherGateway deletePublisherGateway) {
        this.deletePublisherGateway = deletePublisherGateway;
    }

    @Override
    public void deletePublisher(Long publisherId) {
        deletePublisherGateway.deletePublisher(publisherId);
    }
}
