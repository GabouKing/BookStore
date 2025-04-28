package com.gk.bookstore.controller;

import com.gk.bookstore.core.model.Publisher;
import com.gk.bookstore.core.usecases.publisherUsecases.CreatePublisherUseCase;
import com.gk.bookstore.core.usecases.publisherUsecases.DeletePublisherUseCase;
import com.gk.bookstore.core.usecases.publisherUsecases.GetPublisherUseCase;
import com.gk.bookstore.core.usecases.publisherUsecases.UpdatePublisherUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {
    private final GetPublisherUseCase getPublisherUseCase;
    private final CreatePublisherUseCase createPublisherUseCase;
    private final UpdatePublisherUseCase updatePublisherUseCase;
    private final DeletePublisherUseCase deletePublisherUseCase;

    public PublisherController(GetPublisherUseCase getPublisherUseCase,
                               CreatePublisherUseCase createPublisherUseCase,
                               UpdatePublisherUseCase updatePublisherUseCase,
                               DeletePublisherUseCase deletePublisherUseCase) {
        this.getPublisherUseCase = getPublisherUseCase;
        this.createPublisherUseCase = createPublisherUseCase;
        this.updatePublisherUseCase = updatePublisherUseCase;
        this.deletePublisherUseCase = deletePublisherUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getPublishers() {
        return ResponseEntity.ok(getPublisherUseCase.getPublishers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable Long id) {
        return ResponseEntity.ok(getPublisherUseCase.getPublisher(id));
    }

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return new ResponseEntity<Publisher>(createPublisherUseCase.createPublisher(publisher), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher) {
        return new ResponseEntity<>(updatePublisherUseCase.updatePublisher(publisher), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable Long id) {
        deletePublisherUseCase.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }

}
