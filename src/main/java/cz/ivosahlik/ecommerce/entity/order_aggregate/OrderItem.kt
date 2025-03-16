package cz.ivosahlik.ecommerce.entity.order_aggregate

import jakarta.persistence.*

@Entity
@Table(name = "OrderItem")
class OrderItem(
    @Column(name = "Id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Embedded
    var itemOrdered: ProductItemOrdered? = null,

    @Column(name = "Price")
    var price: Long? = null,

    @Column(name = "Quantity")
    var quantity: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: Order? = null
)
