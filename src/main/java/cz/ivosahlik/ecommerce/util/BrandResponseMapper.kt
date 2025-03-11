package cz.ivosahlik.ecommerce.util

import cz.ivosahlik.ecommerce.entity.Brand
import cz.ivosahlik.ecommerce.model.BrandResponse
import org.springframework.stereotype.Component

@Component
class BrandResponseMapper {

    fun convertToBrandResponse(brand: Brand) = BrandResponse(
        id = brand.id,
        name = brand.name
    )
}