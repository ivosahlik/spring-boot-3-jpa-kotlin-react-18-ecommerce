package cz.ivosahlik.ecommerce.entity.order_aggregate

import jakarta.persistence.Embeddable

@Embeddable
data class ShippingAddress(
    val name: String? = null,
    val address1: String? = null,
    val address2: String? = null,
    val city: String? = null,
    val state: String?= null,
    val zipcode: String? = null,
    val country: String? = null
)
