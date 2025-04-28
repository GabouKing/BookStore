package com.gk.bookstore.core.model;

import com.gk.bookstore.core.dto.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private StatusEnum statusEnum;
    private Double Total;

    @OneToMany(mappedBy="orderBuy", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<OrderBook> itens;
}
