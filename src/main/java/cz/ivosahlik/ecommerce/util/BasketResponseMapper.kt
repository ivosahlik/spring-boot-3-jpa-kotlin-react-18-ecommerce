package cz.ivosahlik.ecommerce.util

import cz.ivosahlik.ecommerce.entity.Basket
import cz.ivosahlik.ecommerce.model.BasketItemResponse
import cz.ivosahlik.ecommerce.model.BasketResponse
import org.springframework.stereotype.Component

@Component
class BasketResponseMapper {

    fun convertToBasketResponse(basket: Basket, basketItemResponse: List<BasketItemResponse>) = BasketResponse(
        id = basket.id,
        items = basketItemResponse
    )

}