package cz.ivosahlik.ecommerce.model

data class JwtResponse(
    var username: String? = null,
    var token: String? = null,
)
