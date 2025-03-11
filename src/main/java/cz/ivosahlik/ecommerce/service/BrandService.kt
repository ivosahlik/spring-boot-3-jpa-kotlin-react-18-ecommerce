package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.model.BrandResponse

interface BrandService {
    fun getAllBrands(): List<BrandResponse>
}