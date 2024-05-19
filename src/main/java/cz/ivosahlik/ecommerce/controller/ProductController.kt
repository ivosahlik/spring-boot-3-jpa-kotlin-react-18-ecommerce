package cz.ivosahlik.ecommerce.controller

import cz.ivosahlik.ecommerce.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(val productService: ProductService) {

    @GetMapping("/{id}")
    fun getProductById(@PathVariable("id") productId: Int): String {
       return productService.getProductById(productId)
    }
}