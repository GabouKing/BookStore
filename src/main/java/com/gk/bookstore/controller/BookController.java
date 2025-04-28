package com.gk.bookstore.controller;

import com.gk.bookstore.core.dto.BookDTO;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.core.usecases.bookUsecases.CreateBookUseCase;
import com.gk.bookstore.core.usecases.bookUsecases.DeleteBookUseCase;
import com.gk.bookstore.core.usecases.bookUsecases.GetBookUseCase;
import com.gk.bookstore.core.usecases.bookUsecases.UpdateBookUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final GetBookUseCase getBookUseCase;
    private final CreateBookUseCase createBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;

    public BookController(GetBookUseCase getBookUseCase,
                          CreateBookUseCase createBookUseCase,
                          UpdateBookUseCase updateBookUseCase,
                          DeleteBookUseCase deleteBookUseCase) {
        this.getBookUseCase = getBookUseCase;
        this.createBookUseCase = createBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        return new ResponseEntity<>( getBookUseCase.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>( getBookUseCase.getBook(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDTO book) {
        return new ResponseEntity<>( createBookUseCase.createBook(book), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody BookDTO book) {
        return new ResponseEntity<>(updateBookUseCase.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        deleteBookUseCase.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
