package com.gk.bookstore.infra.repositories;

import com.gk.bookstore.core.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}
