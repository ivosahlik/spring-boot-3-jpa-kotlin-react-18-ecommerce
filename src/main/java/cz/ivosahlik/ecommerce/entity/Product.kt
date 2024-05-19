package cz.ivosahlik.ecommerce.entity

import jakarta.persistence.*

@Entity
@Table(name = "Product")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private var id: Int? = null

    @Column(name = "Name")
    private var name: String? = null

    @Column(name = "Description")
    private var description: String? = null

    @Column(name = "Price")
    private var price: Long? = null

    @Column(name = "PictureUrl")
    private var pictureUrl: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductBrandId", referencedColumnName = "Id")
    private val brand: Brand? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductTypeId", referencedColumnName = "Id")
    private val type: Type? = null
}