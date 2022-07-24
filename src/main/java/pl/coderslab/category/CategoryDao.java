package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class CategoryDao {

    private final EntityManager entityManager;

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
}
