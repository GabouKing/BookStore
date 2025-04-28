package com.gk.bookstore.infra.gateways.paymentGateway;

import com.gk.bookstore.adapters.paymentGateway.CartCheckoutGateway;
import com.gk.bookstore.core.dto.OrderBookDTO;
import com.gk.bookstore.core.dto.OrderDTO;
import com.gk.bookstore.core.dto.StatusEnum;
import com.gk.bookstore.core.model.Book;
import com.gk.bookstore.core.model.OrderBuy;
import com.gk.bookstore.core.model.OrderBook;
import com.gk.bookstore.infra.repositories.BookRepository;
import com.gk.bookstore.infra.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class CartCheckoutGatewayImpl implements CartCheckoutGateway {
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;
    public CartCheckoutGatewayImpl(BookRepository bookRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderBuy checkouOrder(OrderDTO orderDto) {
        if (orderDto.books().isEmpty()) {
            throw new IllegalArgumentException("Books list is empty in this order");
        }
        List<Long> bookIds = orderDto.books().stream()
                .map(OrderBookDTO::BookId)
                .toList();

        List<Book> books = bookRepository.findAllById(bookIds);


        Map<Long, Book> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getId, Function.identity()));

        OrderBuy orderBuy = new OrderBuy();
        orderBuy.setStatusEnum(StatusEnum.IN_PROGRESS);
        orderBuy.setTotal(orderDto.Total());

        List<Book> booksToUpdate = new ArrayList<>();

        List<OrderBook> orderBooks = orderDto.books().stream()
                .map(item -> {
                    Book book = bookMap.get(item.BookId());
                    if (book == null) {
                        throw new IllegalArgumentException("Book not found: " + item.BookId());
                    }
                    if (book.getAmount() < item.Quantity()) {
                        throw new IllegalArgumentException("Not enough stock for book: " + item.BookId());
                    }

                    OrderBook orderBook = new OrderBook();
                    orderBook.setOrderBuy(orderBuy);
                    orderBook.setBook(book);
                    orderBook.setQuantity(item.Quantity());

                    book.setAmount(book.getAmount()-item.Quantity());
                    booksToUpdate.add(book);

                    return orderBook;
                })
                .toList();
        bookRepository.saveAll(booksToUpdate);
        orderBuy.setItens(orderBooks);

        return orderRepository.save(orderBuy);
    }
}
