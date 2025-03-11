package cz.ivosahlik.ecommerce.model

import org.springframework.http.HttpStatus

data class CustomErrorResponse(
     val status: HttpStatus? = null,
     val error: String? = null,
     val message: String? = null
)
