package cz.ivosahlik.ecommerce.entity

import jakarta.persistence.*

@Entity
@Table(name = "Brand")
class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private var id: Int? = null

    @Column(name = "Name")
    private var name: String? = null

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private val prodcts: List<Product>? = null
}