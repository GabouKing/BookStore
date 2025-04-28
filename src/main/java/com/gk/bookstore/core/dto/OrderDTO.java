package com.gk.bookstore.core.dto;

import java.util.List;

public record OrderDTO(Double Total, List<OrderBookDTO> books) {

}
