package cz.ivosahlik.ecommerce.util

import cz.ivosahlik.ecommerce.entity.Product
import cz.ivosahlik.ecommerce.model.ProductResponse
import org.springframework.stereotype.Component

@Component
class ProductResponseMapper {

    fun convertToProductResponse(product: Product) = ProductResponse(
        product.id,
        product.name,
        product.description,
        product.price,
        product.pictureUrl,
        product.brand?.name,
        product.type?.name
    )
}