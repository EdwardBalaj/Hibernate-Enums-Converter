package org.example

enum class Author(val fullname: String) {
    ArthurMcKenzie("Arthur McKenzie"),
    GeorgieCaldwell("Georgie Caldwell");

    companion object {
        fun fromKey(key: String): Author? {
            return values().find { it.fullname == key }
        }
    }
}