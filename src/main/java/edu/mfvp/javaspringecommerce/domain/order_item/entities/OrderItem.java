package edu.mfvp.javaspringecommerce.domain.order_item.entities;

import edu.mfvp.javaspringecommerce.domain.product.entities.Product;

public record OrderItem(
    Product product,
    Integer quantity,
    Double price
) {

}
