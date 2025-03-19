package cz.ivosahlik.ecommerce.util

import cz.ivosahlik.ecommerce.entity.Basket
import cz.ivosahlik.ecommerce.entity.BasketItem
import cz.ivosahlik.ecommerce.model.BasketItemResponse
import cz.ivosahlik.ecommerce.model.BasketResponse
import org.springframework.stereotype.Component

@Component
class BasketResponseMapper {

    fun convertToBasketResponse(basket: Basket, basketItemResponse: List<BasketItemResponse>) = BasketResponse(
        id = basket.id,
        items = basketItemResponse
    )

    fun convertToBasketItemEntity(itemResponse: BasketItemResponse) = BasketItem(
        id = itemResponse.id,
        name = itemResponse.name,
        description = itemResponse.description,
        price = itemResponse.price,
        pictureUrl = itemResponse.pictureUrl,
        productBrand = itemResponse.productBrand,
        productType = itemResponse.productType,
        quantity = itemResponse.quantity,
    )

    fun convertToBasketItemEntity(item: BasketItem) = BasketItemResponse(
        id = item.id,
        name = item.name,
        description = item.description,
        price = item.price,
        pictureUrl = item.pictureUrl,
        productBrand = item.productBrand,
        productType = item.productType,
        quantity = item.quantity,
    )

}