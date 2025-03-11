package cz.ivosahlik.ecommerce.repository

import cz.ivosahlik.ecommerce.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Int> {
    fun findAll(spec: Specification<Product>, pageable: Pageable) : Page<Product>
    fun searchByNameContaining(keyword: String?): Specification<Product?>?
    fun findByBrandId(brandId: Int?): Specification<Product?>?
    fun findByTypeId(typeId: Int?): Specification<Product?>?
    fun findByBrandIdAndTypeId(brandId: Int?, typeId: Int?): Specification<Product?>?
}