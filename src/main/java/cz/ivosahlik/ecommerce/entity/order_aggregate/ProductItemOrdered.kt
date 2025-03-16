package cz.ivosahlik.ecommerce.entity.order_aggregate

import jakarta.persistence.Embeddable

@Embeddable
data class ProductItemOrdered(
    var productId: Int? = null,
    var name: String? = null,
    var pictureUrl: String? = null
)