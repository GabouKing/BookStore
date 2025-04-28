package com.gk.bookstore.infra.gateways.publisherGateway;

import com.gk.bookstore.adapters.publisherGateway.GetPublisherGateway;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.infra.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPublisherGatewayImpl implements GetPublisherGateway {
    private final PublisherRepository publisherRepository;

    public GetPublisherGatewayImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher getPublisher(Long publisherId) {
        return publisherRepository.findById(publisherId).orElseThrow(()->
                new IllegalArgumentException("Publisher not found with id: " + publisherId));
    }

    @Override
    public List<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }
}
