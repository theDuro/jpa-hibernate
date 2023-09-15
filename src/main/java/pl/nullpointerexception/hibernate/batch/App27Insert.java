package pl.nullpointerexception.hibernate.batch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.batching.BatchReview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App27Insert {

    private static Logger logger = LogManager.getLogger(App27Insert.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        long lastId =em.createQuery(
                "Select Max(r.id)" +
                " from BatchReview r"
                , Long.class
        ).getSingleResult();

        for(long i =1; i<=25;i++){
            em.persist(new BatchReview(lastId+i,"recenzja",5,1));
        }
        em.getTransaction().commit();
        em.close();
    }
}
