package sanchez.sanchez.sergio.movie_addicts.core.persistence.db.converter

import io.objectbox.converter.PropertyConverter
import org.json.JSONArray

class StringListConverter : PropertyConverter<List<String?>?, String?> {

    override fun convertToEntityProperty(databaseValue: String?): List<String?>? {
        return if (databaseValue == null) ArrayList() else try {
            val array = JSONArray(databaseValue)
            val ret: ArrayList<String?> = ArrayList()
            for (i in 0 until array.length()) {
                ret.add(array.getString(i))
            }
            ret
        } catch (e: Exception) {
            ArrayList()
        }
    }

    override fun convertToDatabaseValue(entityProperty: List<String?>?): String? {
        return try {
            if (entityProperty == null) null else JSONArray(entityProperty).toString()
        } catch (e: Exception) {
            null
        }
    }
}