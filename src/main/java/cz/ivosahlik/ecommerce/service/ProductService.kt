package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.model.ProductResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ProductService {
    fun getProductById(productId: Int): String
    fun getProducts(pageable: Pageable, brandId: Int, typeId: Int, keyword: String) : Page<ProductResponse>
}