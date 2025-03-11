package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.model.TypeResponse

interface TypeService {
    fun getAllTypes(): List<TypeResponse>

}