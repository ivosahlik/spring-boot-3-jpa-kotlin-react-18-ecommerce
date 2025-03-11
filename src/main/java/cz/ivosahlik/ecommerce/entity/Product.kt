package cz.ivosahlik.ecommerce.entity

import jakarta.persistence.*

@Entity
@Table(name = "Product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    var id: Int? = null,

    @Column(name = "Name")
    var name: String? = null,

    @Column(length = 4096, nullable = true, name = "Description")
    var description: String? = null,

    @Column(name = "Price")
    var price: Long? = null,

    @Column(name = "PictureUrl")
    var pictureUrl: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductBrandId", referencedColumnName = "Id")
    val brand: Brand? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductTypeId", referencedColumnName = "Id")
    val type: Type? = null
)