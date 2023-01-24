package se.me0nly.myJpaOrm1a2.data;

import se.me0nly.myJpaOrm1a2.model.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class DetailsDAORepository implements DetailsDAO{

    private final EntityManager em;

    @Autowired
    public DetailsDAORepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public About findById(Integer integer) {
        return em.find(About.class, integer);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<About> findAll() {
        return em.createQuery("SELECT d FROM About d", About.class).getResultList();
    }

    @Override
    @Transactional
    public About create(About about) {
        em.persist(about);
        return about;
    }

    @Override
    @Transactional
    public About update(About about) {
        return em.merge(about);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        About about = findById(integer);
        if(about != null){
            em.remove(about);
        }

    }
}
