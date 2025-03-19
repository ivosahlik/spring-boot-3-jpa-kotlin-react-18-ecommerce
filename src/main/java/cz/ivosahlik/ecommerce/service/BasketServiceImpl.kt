package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.entity.Basket
import cz.ivosahlik.ecommerce.model.BasketResponse
import cz.ivosahlik.ecommerce.repository.BasketRepository
import cz.ivosahlik.ecommerce.util.BasketItemResponseMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class BasketServiceImpl(
    val basketRepository: BasketRepository,
    val basketItemResponseMapper: BasketItemResponseMapper
) : BasketService {

    private val log = KotlinLogging.logger {}

    override fun getAllBaskets(): List<BasketResponse?> {
        return basketRepository.findAll()
            .map { basket: Basket -> this.convertToBasketResponse(basket) }
            .toList()
    }

    override fun getBasketById(basketId: String): BasketResponse? {
        log.info { "${"Fetching Basket by Id: {}"} $basketId" }
        val basketOptional = basketRepository.findById(basketId)
        if (basketOptional.isEmpty) {
            log.info { "${"Basket with Id: {} not found"} $basketId" }
            return null
        }
        val basket = basketOptional.get()
        log.info { "${"Fetched Basket by Id: {}"} $basketId" }
        return convertToBasketResponse(basket)
    }

    override fun deleteBasketById(basketId: String) {
        log.info { "${"Deleting Basket by Id: {}"} $basketId" }
        basketRepository.deleteById(basketId)
        log.info { "${"Deleted Basket by Id: {}"} $basketId" }
    }

    override fun createBasket(basket: Basket): BasketResponse? {
        log.info { "Creating Basket" }
        val savedBasket: Basket = basketRepository.save(basket)
        log.info { "${"Basket created with Id: {}"} ${savedBasket.id}" }
        return convertToBasketResponse(savedBasket)
    }

    private fun convertToBasketResponse(basket: Basket?): BasketResponse? {
        if (basket == null) {
            return null
        }
        if (basket.items == null) {
            return null
        }
        val basketItemResponses = basket.items.stream()
            .map { basketItemResponse -> basketItemResponseMapper.convertToBasketItemResponse(basketItemResponse) }
            .toList()
        return basketItemResponseMapper.convertToBasketResponse(basket, basketItemResponses)
    }

}