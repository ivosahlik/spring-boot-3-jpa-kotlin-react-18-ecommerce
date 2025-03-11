package cz.ivosahlik.ecommerce.service

import cz.ivosahlik.ecommerce.entity.Type
import cz.ivosahlik.ecommerce.model.TypeResponse
import cz.ivosahlik.ecommerce.repository.TypeRepository
import cz.ivosahlik.ecommerce.util.TypeResponseMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class TypeServiceImpl(
    val typeRepository: TypeRepository,
    val typeResponseMapper: TypeResponseMapper
) : TypeService {

    private val logger = KotlinLogging.logger {}

    override fun getAllTypes(): List<TypeResponse> {
        logger.info { "Fetching All Types!!!" }
        return typeRepository.findAll().stream()
            .map { type: Type -> typeResponseMapper.convertToTypeResponse(type) }
            .toList()
    }
}