package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.model.ProductResponse

interface ProductService {

    fun getProductById(productId: Int): String

}