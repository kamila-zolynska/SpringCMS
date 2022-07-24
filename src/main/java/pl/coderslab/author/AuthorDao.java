package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class AuthorDao {

    private final EntityManager entityManager;

    public void create(Author author) {
        entityManager.persist(author);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void remove(Author author) {
        entityManager.remove(entityManager.contains(author)
                ? author : entityManager.merge(author));
    }
}
