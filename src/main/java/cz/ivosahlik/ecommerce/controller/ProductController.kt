package cz.ivosahlik.ecommerce.controller

import cz.ivosahlik.ecommerce.model.BrandResponse
import cz.ivosahlik.ecommerce.model.ProductResponse
import cz.ivosahlik.ecommerce.model.TypeResponse
import cz.ivosahlik.ecommerce.service.BrandService
import cz.ivosahlik.ecommerce.service.ProductService
import cz.ivosahlik.ecommerce.service.TypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    val productService: ProductService,
    val brandService: BrandService,
    val typeService: TypeService
) {

    @GetMapping("/{id}")
    fun getProductById(@PathVariable("id") productId: Int): ResponseEntity<String>
        = ResponseEntity.ok(productService.getProductById(productId))

    //http://localhost:8081/api/products?brandId=1&typeId=1&keyword=a
    @GetMapping
    fun getProducts(
        @RequestParam(name = "page", defaultValue = "0") page: Int,
        @RequestParam(name = "size", defaultValue = "10") size: Int,
        @RequestParam(name = "keyword", required = false) keyword: String,
        @RequestParam(name = "brandId", required = false) brandId: Int,
        @RequestParam(name = "typeId", required = false) typeId: Int,
        @RequestParam(name = "sort", defaultValue = "name") sort: String,
        @RequestParam(name = "order", defaultValue = "asc") order: String
    ): ResponseEntity<Page<ProductResponse>> {
        val pageable = getPageable(page, size, sort, order)
        val productResponses: Page<ProductResponse> = productService.getProducts(pageable, brandId, typeId, keyword)
        return ResponseEntity(productResponses, HttpStatus.OK)
    }

    private fun getPageable(page: Int, size: Int, sort: String, order: String): Pageable {
        val direction = if (order.equals("desc", ignoreCase = true)) Sort.Direction.DESC else Sort.Direction.ASC
        val sorting = Sort.by(direction, sort)
        return PageRequest.of(page, size, sorting)
    }

    @GetMapping("/brands")
    fun getBrands(): ResponseEntity<List<BrandResponse>> {
        val brandResponses: List<BrandResponse> = brandService.getAllBrands()
        return ResponseEntity(brandResponses, HttpStatus.OK)
    }

    @GetMapping("/types")
    fun getTypes(): ResponseEntity<List<TypeResponse>> {
        val typeResponses: List<TypeResponse> = typeService.getAllTypes()
        return ResponseEntity(typeResponses, HttpStatus.OK)
    }
}