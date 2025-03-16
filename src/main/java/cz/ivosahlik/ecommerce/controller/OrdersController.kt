package cz.ivosahlik.ecommerce.controller

import cz.ivosahlik.ecommerce.model.OrderResponse
import cz.ivosahlik.ecommerce.service.OrderService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}