package pl.coderslab.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class ArticleDao {
    
    private final EntityManager entityManager;

    public void create(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void remove(Article article) {
        entityManager.remove(entityManager.contains(article)
                ? article : entityManager.merge(article) );
    }
}
