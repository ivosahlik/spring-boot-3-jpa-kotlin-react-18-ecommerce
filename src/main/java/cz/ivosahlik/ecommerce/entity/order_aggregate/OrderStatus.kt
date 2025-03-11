package cz.ivosahlik.ecommerce.entity.order_aggregate

enum class OrderStatus {
    PENDING,
    PAYMENT_RECEIVED,
    PAYMENT_FAILED
}