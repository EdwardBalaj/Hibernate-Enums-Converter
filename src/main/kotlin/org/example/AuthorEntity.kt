package org.example

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "author")
open class AuthorEntity {

    @Id
    @Column(name = "fullname", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    open var fullname: Author? = null

    override fun equals(other: Any?): Boolean {
        return this === other || (other is AuthorEntity
                && fullname == other.fullname)
    }

    override fun hashCode(): Int {
        return fullname.hashCode()
    }
}