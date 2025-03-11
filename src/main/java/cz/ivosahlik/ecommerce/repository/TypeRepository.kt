package cz.ivosahlik.ecommerce.repository

import cz.ivosahlik.ecommerce.entity.Type
import org.springframework.data.jpa.repository.JpaRepository

interface TypeRepository : JpaRepository<Type, Int>