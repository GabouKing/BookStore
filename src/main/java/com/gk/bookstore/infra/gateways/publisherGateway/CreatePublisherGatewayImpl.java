package com.gk.bookstore.infra.gateways.publisherGateway;

import com.gk.bookstore.adapters.publisherGateway.CreatePublisherGateway;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.infra.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePublisherGatewayImpl implements CreatePublisherGateway {
    private final PublisherRepository publisherRepository;

    public CreatePublisherGatewayImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}
