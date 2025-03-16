package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.entity.order_aggregate.Order
import cz.ivosahlik.ecommerce.entity.order_aggregate.OrderItem
import cz.ivosahlik.ecommerce.entity.order_aggregate.ProductItemOrdered
import cz.ivosahlik.ecommerce.model.BasketItemResponse
import cz.ivosahlik.ecommerce.model.BasketResponse
import cz.ivosahlik.ecommerce.model.OrderDto
import cz.ivosahlik.ecommerce.model.OrderResponse
import cz.ivosahlik.ecommerce.repository.OrderRepository
import cz.ivosahlik.ecommerce.util.OrderMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class OrderServiceImpl (
    val orderRepository: OrderRepository,
    val basketService: BasketService,
    val orderMapper: OrderMapper
) : OrderService {

    private val log = KotlinLogging.logger {}

    override fun getOrderById(orderId: Int): OrderResponse {
        val optionalOrder: Optional<Order> = orderRepository.findById(orderId)
        return optionalOrder.map(orderMapper::orderToOrderResponse).orElse(null)
    }

    override fun getAllOrders(): List<OrderResponse> {
        val orders: List<Order> = orderRepository.findAll()
        return orders.stream().map(orderMapper::orderToOrderResponse).toList()
    }

    override fun getAllOrders(pageable: Pageable): Page<OrderResponse> {
        return orderRepository.findAll(pageable).map(orderMapper::orderToOrderResponse)
    }

    override fun deleteOrder(orderId: Int) {
        orderRepository.deleteById(orderId)
    }

    override fun createOrder(orderDto: OrderDto): Int? {
        val basketResponse: BasketResponse? = orderDto.basketId?.let { basketService.getBasketById(it) }
        if (basketResponse?.items == null) {
            return null
        }
        val orderItems = basketResponse.items.stream()
            .map { basketItemResponse: BasketItemResponse -> this.mapBasketItemToOrderItem(basketItemResponse) }
            .toList()
        if (orderItems == null) {
            return null
        }
        val subTotal = basketResponse.items.stream()
            .mapToDouble { obj -> this.calculateSubTotal(obj).toDouble() }
            .sum()
        val order: Order = orderMapper.orderResponseToOrder(orderDto)
        order.orderItems = orderItems
        order.subTotal = subTotal.toLong()

        val savedOrder: Order? = order.let { orderRepository.save(it) }
        orderDto.basketId.let { basketService.deleteBasketById(it) }
        return savedOrder!!.id
    }

    private fun calculateSubTotal(item: BasketItemResponse): Long {
        return item.price!! * item.quantity!!
    }

    private fun mapBasketItemToOrderItem(basketItemResponse: BasketItemResponse): OrderItem {
        val orderItem = OrderItem()
        orderItem.itemOrdered = mapBasketItemToProduct(basketItemResponse)
        basketItemResponse.quantity?.let { orderItem.quantity = it }
        return orderItem
    }

    private fun mapBasketItemToProduct(basketItemResponse: BasketItemResponse): ProductItemOrdered {
        val productItemOrdered = ProductItemOrdered()
        basketItemResponse.name?.let { productItemOrdered.name = it }
        basketItemResponse.pictureUrl?.let { productItemOrdered.pictureUrl = it }
        basketItemResponse.id?.let { productItemOrdered.productId = it }
        return productItemOrdered
    }
}