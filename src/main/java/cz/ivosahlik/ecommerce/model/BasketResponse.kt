package cz.ivosahlik.ecommerce.model

data class BasketResponse(
    val id: String,
    val items: List<BasketItemResponse>? = null
)
