package cz.ivosahlik.ecommerce.model

import cz.ivosahlik.ecommerce.entity.order_aggregate.ShippingAddress
import java.time.LocalDateTime

data class OrderDto(
    val basketId: String? = null,
    val shippingAddress: ShippingAddress? = null,
    val subTotal: Long? = null,
    val deliveryFee: Long? = null,
    val orderDate: LocalDateTime? = null
)
