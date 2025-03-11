package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.entity.Brand
import cz.ivosahlik.ecommerce.model.BrandResponse
import cz.ivosahlik.ecommerce.repository.BrandRepository
import cz.ivosahlik.ecommerce.util.BrandResponseMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class BrandServiceImpl(
    val brandRepository: BrandRepository,
    val brandResponseMapper: BrandResponseMapper
) : BrandService {
    private val logger = KotlinLogging.logger {}

    override fun getAllBrands(): List<BrandResponse> {
        logger.info { "Fetching All Brands!!!" }
        return brandRepository.findAll().stream()
            .map { brand: Brand -> brandResponseMapper.convertToBrandResponse(brand) }
            .toList()
    }
}