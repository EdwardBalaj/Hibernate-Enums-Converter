package org.example

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "book")
open class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false, updatable = false)
    open var bookId: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fullname", referencedColumnName = "fullname", nullable = false, updatable = false)
    open var fullname: AuthorEntity = AuthorEntity()

    @Column(name="date")
    open var date: Instant? = null
}