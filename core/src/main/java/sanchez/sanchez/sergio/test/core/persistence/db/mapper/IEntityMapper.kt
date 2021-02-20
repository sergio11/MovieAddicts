package sanchez.sanchez.sergio.test.core.persistence.db.mapper

/**
 * Entity To Model mapper
 */
interface IEntityToModelMapper<IN, OUT> {

    /**
     * Entity to model
     * @param entity
     */
    fun entityToModel(entity: IN): OUT

    /**
     * Entity To Model
     * @param entityList
     */
    fun entityToModel(entityList: List<IN>): List<OUT>

    /**
     * Model To Entity
     * @param model
     */
    fun modelToEntity(model: OUT): IN

    /**
     * Model To Entity
     * @param modelList
     */
    fun modelToEntity(modelList: List<OUT>): List<IN>
}