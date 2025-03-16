package cz.ivosahlik.ecommerce.repository

import cz.ivosahlik.ecommerce.entity.Basket
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BasketRepository : CrudRepository<Basket, String>