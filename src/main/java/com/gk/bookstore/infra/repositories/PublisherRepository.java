package com.gk.bookstore.infra.repositories;

import com.gk.bookstore.core.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
