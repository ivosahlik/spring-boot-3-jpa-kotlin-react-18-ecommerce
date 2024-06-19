package cz.ivosahlik.ecommerce.entity

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("BasketItem")
data class BasketItem (
    @Id
    val id: Int?,
    val name: String?,
    val description: String?,
    val price: Long?,
    val pictureUrl: String?,
    val productBrand: String?,
    val productType: String?,
    val quantity: Int?
)
