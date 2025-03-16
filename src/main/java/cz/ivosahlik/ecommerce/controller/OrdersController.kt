package cz.ivosahlik.ecommerce.controller

import cz.ivosahlik.ecommerce.model.OrderDto
import cz.ivosahlik.ecommerce.model.OrderResponse
import cz.ivosahlik.ecommerce.service.OrderService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrdersController(
    private val orderService: OrderService
) {
    private val log = KotlinLogging.logger {}

    @GetMapping("/{orderId}")
    fun getOrderById(@PathVariable orderId: Int): ResponseEntity<OrderResponse> {
        val order: OrderResponse? = orderService.getOrderById(orderId)
        if (order == null) {
            log.warn { "Order not found by id $orderId" }
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(order)
    }

    @GetMapping
    fun getAllOrders(): ResponseEntity<List<OrderResponse>> {
        val orders = orderService.getAllOrders()
        return ResponseEntity.ok(orders)
    }

    @GetMapping("/paged")
    fun getAllOrdersPaged(pageable: Pageable): ResponseEntity<Page<OrderResponse>> {
        val orders = orderService.getAllOrders(pageable)
        return ResponseEntity.ok(orders)
    }

    @PostMapping
    fun createOrder(@Validated @RequestBody orderDto: OrderDto): ResponseEntity<Int> {
        val orderId = orderService.createOrder(orderDto)
            ?: return ResponseEntity.status(INTERNAL_SERVER_ERROR).build()
        return ResponseEntity.status(CREATED).body(orderId)
    }

    @DeleteMapping("/{orderId}")
    fun deleteOrder(@PathVariable orderId: Int): ResponseEntity<Void> {
        orderService.deleteOrder(orderId)
        return ResponseEntity.noContent().build()
    }

}