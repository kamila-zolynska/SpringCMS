package pl.coderslab.category;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Category category) {
        entityManager.persist(category);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void remove(Category category) {
        entityManager.remove(entityManager.contains(category)
                ? category : entityManager.merge(category) );
    }

    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c")
                .getResultList();
    }

    public Category findById(Long id) {
        Query query = entityManager.createQuery("select c from Category c where c.id = ?1", Category.class);
        return (Category) query.setParameter(1, id).getSingleResult();
    }
}
