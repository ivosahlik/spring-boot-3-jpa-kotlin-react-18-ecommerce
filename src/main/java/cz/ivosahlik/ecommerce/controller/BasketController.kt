package cz.ivosahlik.ecommerce.controller

import cz.ivosahlik.ecommerce.entity.Basket
import cz.ivosahlik.ecommerce.entity.BasketItem
import cz.ivosahlik.ecommerce.model.BasketItemResponse
import cz.ivosahlik.ecommerce.model.BasketResponse
import cz.ivosahlik.ecommerce.service.BasketService
import cz.ivosahlik.ecommerce.util.BasketResponseMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/baskets")
class BasketController(
    val basketService: BasketService,
    val basketResponseMapper: BasketResponseMapper
) {

    @GetMapping
    fun getAllBaskets(): List<BasketResponse?> {
        return basketService.getAllBaskets()
    }


    @GetMapping("/{basketId}")
    fun getBasketById(@PathVariable basketId: String): BasketResponse? {
        return basketService.getBasketById(basketId)
    }

    @DeleteMapping("/{basketId}")
    fun deleteBasketById(@PathVariable basketId: String) {
        basketService.deleteBasketById(basketId)
    }

    @PostMapping
    fun createBasket(@RequestBody basketResponse: BasketResponse): ResponseEntity<BasketResponse?> {
        val basket = convertToBasketEntity(basketResponse)
        val createdBasket = basketService.createBasket(basket)
        return ResponseEntity(createdBasket, HttpStatus.CREATED)
    }

    private fun convertToBasketEntity(basketResponse: BasketResponse): Basket {
        val basket = Basket(
            id = basketResponse.id,
            items = basketResponse.items?.let { mapBasketItemResponsesToEntities(it) }
        )
        return basket
    }

    private fun mapBasketItemResponsesToEntities(itemResponses: List<BasketItemResponse>): List<BasketItem> {
        return itemResponses.stream()
            .map { itemResponse: BasketItemResponse -> basketResponseMapper.convertToBasketItemEntity(itemResponse) }
            .toList()
    }

}
