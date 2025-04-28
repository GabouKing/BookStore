package com.gk.bookstore.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.Flow;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer amount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_publisher")
    private Publisher publisher;

    @OneToMany(mappedBy="book", cascade=CascadeType.ALL, orphanRemoval=true)
    @JsonIgnore
    private List<OrderBook> itens;
}
