package org.example

fun main() {
    val sessionFactory = HibernateUtil.sessionFactory
    val session = sessionFactory.currentSession

    session.beginTransaction()

    try {
        val queryEntitiesWithEntity = session
            .createQuery(
                """
                from BookEntity
                where 
                        fullname = :fullname
            """.trimIndent(), BookEntity::class.java
            ).also {
                it.setParameter("fullname", AuthorEntity().apply { this.fullname = Author.ArthurMcKenzie })
            }

        val firstList = queryEntitiesWithEntity.list()
    } catch (exception: Exception) {
        println(exception)
    }

    try {
        val queryEntitiesEnum = session
            .createQuery(
                """
                from BookEntity
                where 
                        fullname.fullname = :fullname
            """.trimIndent(), BookEntity::class.java
            ).also {
                it.setParameter("fullname", Author.GeorgieCaldwell)
            }

        val secondList = queryEntitiesEnum.list()
    } catch (exception: Exception) {
        println(exception)
    }
}