package cz.ivosahlik.ecommerce.service

import org.springframework.stereotype.Service

@Service
class ProductServiceImpl : ProductService {
    override fun getProductById(productId: Int): String {
        return "Not yet implemented, productId = $productId"
    }
}