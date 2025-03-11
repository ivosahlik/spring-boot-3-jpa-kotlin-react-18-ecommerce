package cz.ivosahlik.ecommerce.model

data class ProductResponse(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val price: Long? = null,
    val pictureUrl: String? = null,
    val productBrand: String? = null,
    val productType: String? = null
)