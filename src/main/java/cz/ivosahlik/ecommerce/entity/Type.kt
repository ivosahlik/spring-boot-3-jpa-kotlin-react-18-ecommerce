package cz.ivosahlik.ecommerce.entity

import jakarta.persistence.*

@Entity
@Table(name = "Type")
class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    var id: Int? = null

    @Column(name = "Name")
    var name: String? = null

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    val products: List<Product>? = null
}
