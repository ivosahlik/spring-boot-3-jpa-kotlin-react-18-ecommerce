package cz.ivosahlik.ecommerce.entity

import jakarta.persistence.*

@Entity
@Table(name = "Brand")
class Brand(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    var id: Int? = null,

    @Column(name = "Name")
    var name: String? = null,

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    val products: List<Product>? = null
)