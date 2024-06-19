package cz.ivosahlik.ecommerce.entity

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Bakset")
data class Basket(
    @Id val id: String,
    val items: List<BasketItem>,
)
