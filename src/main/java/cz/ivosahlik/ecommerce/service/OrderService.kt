package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.model.OrderDto
import cz.ivosahlik.ecommerce.model.OrderResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface OrderService {
    fun getOrderById(orderId: Int): OrderResponse?
    fun getAllOrders(): List<OrderResponse>
    fun getAllOrders(pageable: Pageable): Page<OrderResponse>
    fun createOrder(order: OrderDto): Int?
    fun deleteOrder(orderId: Int)
}