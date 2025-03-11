package cz.ivosahlik.ecommerce.model

data class JwtRequest(
    var username: String? = null,
    var password: String? = null
)
