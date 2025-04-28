package com.gk.bookstore.core.dto;

public record BookDTO(Long id, String title, String author, Long publisherId, Integer amount) {
}
