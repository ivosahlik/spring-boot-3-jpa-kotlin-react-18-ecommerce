package cz.ivosahlik.ecommerce.repository

import cz.ivosahlik.ecommerce.entity.order_aggregate.Order
import cz.ivosahlik.ecommerce.entity.order_aggregate.OrderStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface OrderRepository : JpaRepository<Order, Int> {
    fun findByBasketId(basketId: String?): List<Order?>?
    fun findByOrderStatus(orderStatus: OrderStatus?): List<Order?>?
    fun findByOrderDateBetween(startdate: LocalDateTime?, endDate: LocalDateTime?): List<Order?>?

    @Query(
        """
        SELECT o FROM Order o JOIN o.orderItems oi
        WHERE oi.itemOrdered.name LIKE %:productName%
        """
    )
    fun findByProductNameInOrderItems(@Param("productName") productName: String?): List<Order?>?

    @Query(
        """
        SELECT o FROM Order o 
        WHERE o.shippingAddress.city = :city
        """
    )
    fun findByShippingAddressCity(@Param("city") city: String?): List<Order?>?
}