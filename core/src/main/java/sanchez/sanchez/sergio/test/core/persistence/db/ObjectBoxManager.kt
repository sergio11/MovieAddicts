package sanchez.sanchez.sergio.test.core.persistence.db

import io.objectbox.BoxStore

class ObjectBoxManager {

    private val objectBoxStore by lazy {
        mutableMapOf<String, BoxStore>()
    }

    /**
     * Return object box by name
     * @param name
     */
    fun getBoxStore(name: String): BoxStore? = objectBoxStore[name]

    /**
     * Register Box Store by name
     * @param name
     * @param boxStore
     */
    fun registerBoxStore(name: String, boxStore: BoxStore) {
        objectBoxStore[name] = boxStore
    }

}