package pl.coderslab.article;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void remove(Article article) {
        entityManager.remove(entityManager.contains(article)
                ? article : entityManager.merge(article));
    }

    public List<Article> findAll() {
        return entityManager.createQuery("select a from Article a")
                .getResultList();
    }

    public List<Article> findFiveTheNewestArticles() {
        return entityManager.createQuery("select a from Article a order by a.created")
                .setMaxResults(5)
                .getResultList();
    }
}
