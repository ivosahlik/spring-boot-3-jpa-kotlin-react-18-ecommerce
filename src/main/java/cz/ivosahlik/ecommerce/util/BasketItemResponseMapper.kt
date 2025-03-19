package cz.ivosahlik.ecommerce.util

import cz.ivosahlik.ecommerce.entity.Basket
import cz.ivosahlik.ecommerce.entity.BasketItem
import cz.ivosahlik.ecommerce.model.BasketItemResponse
import cz.ivosahlik.ecommerce.model.BasketResponse
import org.springframework.stereotype.Component

@Component
class BasketItemResponseMapper {

    fun convertToBasketItemResponse(basketItem: BasketItem) = BasketItemResponse(
        id = basketItem.id,
        name = basketItem.name,
        description = basketItem.description,
        price = basketItem.price,
        pictureUrl = basketItem.pictureUrl,
        productBrand = basketItem.productBrand,
        productType = basketItem.productType,
        quantity = basketItem.quantity
    )

    fun convertToBasketResponse(basket: Basket, basketItemResponses: List<BasketItemResponse>) = BasketResponse(
        id = basket.id,
        items = basketItemResponses
    )

}