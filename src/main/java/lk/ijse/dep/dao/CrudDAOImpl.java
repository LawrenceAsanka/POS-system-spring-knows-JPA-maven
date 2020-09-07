package lk.ijse.dep.dao;

import lk.ijse.dep.entity.SuperEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CrudDAOImpl<T extends SuperEntity, ID extends Serializable> implements CrudDAO<T, ID> {

    private final Class<T> entity;
    protected EntityManager entityManager;

    public CrudDAOImpl() {
        entity = (Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    @Override
    public List<T> findAll() throws Exception {
        return entityManager.createQuery("FROM " + entity.getName()).getResultList();
    }

    @Override
    public T find(ID key) throws Exception {
        return entityManager.find(entity, key);
    }

    @Override
    public void save(T entity) throws Exception {
        entityManager.persist(entity);
    }

    //update wenuwata merge use krai jpa wala...
    @Override
    public void update(T entity) throws Exception {
        entityManager.merge(entity);
    }

    @Override
    public void delete(ID key) throws Exception {
        entityManager.remove(entityManager.find(entity, key));
    }
}
