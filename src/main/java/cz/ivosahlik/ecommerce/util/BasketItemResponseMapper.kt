package cz.ivosahlik.ecommerce.util

import cz.ivosahlik.ecommerce.entity.BasketItem
import cz.ivosahlik.ecommerce.model.BasketItemResponse
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

}