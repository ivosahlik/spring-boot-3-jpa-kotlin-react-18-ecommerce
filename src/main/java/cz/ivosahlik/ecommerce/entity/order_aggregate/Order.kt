package cz.ivosahlik.ecommerce.entity.order_aggregate

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Id")
    var id: Int? = null,

    @Column(name = "Basket_Id")
    var basketId: String? = null,

    @Embedded
    var shippingAddress: ShippingAddress? = null,

    @Column(name = "Order_Date")
    var orderDate: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "Order_ITEMS")
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "order")
    var orderItems: List<OrderItem>? = null,

    @Column(name = "Sub_Total")
    var subTotal: Long? = null,

    @Column(name = "Delivery_Fee")
    var deliveryFee: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "Order_Status")
    var orderStatus: OrderStatus = OrderStatus.PENDING,
) {
    fun getTotal() : Double = getSubTotal() + getDeliveryFee()
    fun getSubTotal() : Double = subTotal?.toDouble() ?: 0.0
    fun getDeliveryFee() : Long = deliveryFee ?: 0L

}
