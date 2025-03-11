package cz.ivosahlik.ecommerce.entity.order_aggregate

import jakarta.persistence.Embeddable

@Embeddable
data class ProductItemOrdered(
    val productId: Int? = null,
    val name: String? = null,
    val pictureUrl: String? = null
)
