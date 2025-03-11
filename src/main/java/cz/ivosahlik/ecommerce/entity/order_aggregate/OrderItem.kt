package cz.ivosahlik.ecommerce.entity.order_aggregate

import jakarta.persistence.*

@Entity
@Table(name = "OrderItem")
data class OrderItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Id")
    private var id: Int? = null,

    @Embedded
    private val itemOrdered: ProductItemOrdered? = null,

    @Column(name = "Price")
    private var price: Long? = null,

    @Column(name = "Quantity")
    private var quantity: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private val order: Order? = null
)
