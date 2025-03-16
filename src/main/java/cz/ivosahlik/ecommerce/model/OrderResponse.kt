package cz.ivosahlik.ecommerce.model

import cz.ivosahlik.ecommerce.entity.order_aggregate.OrderStatus
import cz.ivosahlik.ecommerce.entity.order_aggregate.ShippingAddress
import java.time.LocalDateTime

data class OrderResponse(
    var id: Int? = null,
    var basketId: String? = null,
    var shippingAddress: ShippingAddress? = null,
    var subTotal: Long? = null,
    var deliveryFee: Long? = null,
    var total: Long? = null,
    var orderDate: LocalDateTime? = null,
    var orderStatus: OrderStatus? = null
)
