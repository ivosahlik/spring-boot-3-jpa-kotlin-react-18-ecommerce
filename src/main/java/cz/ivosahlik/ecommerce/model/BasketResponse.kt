package cz.ivosahlik.ecommerce.model

data class BasketResponse(
    val id: String? = null,
    val items: List<BasketItemResponse>? = null
)
