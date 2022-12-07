package org.example

import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration

class HibernateUtil {

    companion object {
        val sessionFactory = HibernateUtil().buildSessionFactory()
    }

    private fun buildSessionFactory(): SessionFactory {
        return try {
            val configuration = Configuration()

            configuration.configure("hibernate.cfg.xml")
            configuration.addAnnotatedClass(AuthorEntity::class.java)
            configuration.addAnnotatedClass(BookEntity::class.java)

            val serviceRegistry = StandardServiceRegistryBuilder().applySettings(configuration.properties).build()
            configuration.buildSessionFactory(serviceRegistry)
        } catch (ex: Throwable) {
            ex.printStackTrace()
            throw ExceptionInInitializerError(ex)
        }
    }

}