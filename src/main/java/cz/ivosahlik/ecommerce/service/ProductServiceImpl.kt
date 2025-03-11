package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.entity.Product
import cz.ivosahlik.ecommerce.model.ProductResponse
import cz.ivosahlik.ecommerce.repository.ProductRepository
import cz.ivosahlik.ecommerce.util.ProductResponseMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Root
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val productResponseMapper: ProductResponseMapper
) : ProductService {
    private val logger = KotlinLogging.logger {}

    override fun getProductById(productId: Int): String {
        logger.info { "Fetching Product $productId!" }
        return "Not yet implemented, productId = $productId"
    }

    override fun getProducts(pageable: Pageable, brandId: Int, typeId: Int, keyword: String): Page<ProductResponse> {
        val spec = getProductSpecification(brandId, typeId, keyword)
        return productRepository
            .findAll(spec, pageable)
            .map { product: Product -> productResponseMapper.convertToProductResponse(product) }
    }

    private fun getProductSpecification(
        brandId: Int?,
        typeId: Int?,
        keyword: String?
    ): Specification<Product> {
        var spec = Specification.where<Product>(null)

        if (brandId != null) {
            spec = spec.and { root: Root<Product>, query: CriteriaQuery<*>?, criteriaBuilder: CriteriaBuilder ->
                criteriaBuilder.equal(
                    root.get<Any>("brand").get<Any>("id"),
                    brandId
                )
            }
        }

        if (typeId != null) {
            spec = spec.and { root: Root<Product>, query: CriteriaQuery<*>?, criteriaBuilder: CriteriaBuilder ->
                criteriaBuilder.equal(
                    root.get<Any>("type").get<Any>("id"),
                    typeId
                )
            }
        }

        if (keyword != null && !keyword.isEmpty()) {
            spec = spec.and { root: Root<Product>, query: CriteriaQuery<*>?, criteriaBuilder: CriteriaBuilder ->
                criteriaBuilder.like(
                    root.get("name"),
                    "%$keyword%"
                )
            }
        }
        return spec
    }
}