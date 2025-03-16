package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.entity.Basket
import cz.ivosahlik.ecommerce.model.BasketResponse

interface BasketService {
    fun getAllBaskets(): List<BasketResponse?>
    fun getBasketById(basketId: String): BasketResponse?
    fun deleteBasketById(basketId: String)
    fun createBasket(basket: Basket): BasketResponse?
}