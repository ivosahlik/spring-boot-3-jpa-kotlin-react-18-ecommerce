package cz.ivosahlik.ecommerce.model

import cz.ivosahlik.ecommerce.entity.order_aggregate.OrderStatus
import cz.ivosahlik.ecommerce.entity.order_aggregate.ShippingAddress
import java.time.LocalDateTime

data class OrderResponse(
    private val id: Int? = null,
    val basketId: String? = null,
    val shippingAddress: ShippingAddress? = null,
    val subTotal: Long? = null,
    val deliveryFee: Long? = null,
    val total: Double? = null,
    val orderDate: LocalDateTime? = null,
    val orderStatus: OrderStatus? = null
)
