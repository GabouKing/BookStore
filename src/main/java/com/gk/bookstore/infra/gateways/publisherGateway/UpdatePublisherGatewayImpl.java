package com.gk.bookstore.infra.gateways.publisherGateway;

import com.gk.bookstore.adapters.publisherGateway.UpdatePublisherGateway;
import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.infra.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdatePublisherGatewayImpl implements UpdatePublisherGateway {
    private final PublisherRepository publisherRepository;

    public UpdatePublisherGatewayImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}
