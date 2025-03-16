package cz.ivosahlik.ecommerce.util

import cz.ivosahlik.ecommerce.entity.order_aggregate.Order
import cz.ivosahlik.ecommerce.entity.order_aggregate.OrderStatus
import cz.ivosahlik.ecommerce.model.OrderDto
import cz.ivosahlik.ecommerce.model.OrderResponse
import org.springframework.stereotype.Component

@Component
class OrderMapper {

    fun orderToOrderResponse(order: Order) = OrderResponse(
        id = order.id,
        basketId = order.basketId,
        shippingAddress = order.shippingAddress,
        subTotal = order.subTotal,
        deliveryFee = order.deliveryFee,
        total = order.subTotal?.plus(order.deliveryFee!!),
        orderDate = order.orderDate,
        orderStatus = order.orderStatus,
    )

    fun orderResponseToOrder(orderDto: OrderDto) = Order(
        basketId = orderDto.basketId,
        shippingAddress = orderDto.shippingAddress,
        subTotal = orderDto.subTotal,
        orderStatus = OrderStatus.PENDING,
        deliveryFee = orderDto.deliveryFee,
        orderDate = orderDto.orderDate,
    )

}
