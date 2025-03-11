package cz.ivosahlik.ecommerce.util

import cz.ivosahlik.ecommerce.entity.Brand
import cz.ivosahlik.ecommerce.entity.Type
import cz.ivosahlik.ecommerce.model.BrandResponse
import cz.ivosahlik.ecommerce.model.TypeResponse
import org.springframework.stereotype.Component

@Component
class TypeResponseMapper {

    fun convertToTypeResponse(type: Type) = TypeResponse(
        id = type.id,
        name = type.name
    )
}