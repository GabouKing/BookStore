package com.gk.bookstore.infra.gateways.publisherGateway;

import com.gk.bookstore.adapters.publisherGateway.DeletePublisherGateway;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.infra.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletePublisherGatewayImpl implements DeletePublisherGateway {
    private final PublisherRepository publisherRepository;

    public DeletePublisherGatewayImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void deletePublisher(Long publisherId) {
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow(()->
                new IllegalArgumentException("Publisher not found for id: " + publisherId));
        publisherRepository.delete(publisher);
    }
}
