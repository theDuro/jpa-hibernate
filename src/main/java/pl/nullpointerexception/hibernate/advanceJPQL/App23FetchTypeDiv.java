package pl.nullpointerexception.hibernate.advanceJPQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App23FetchTypeDiv {

    private static Logger logger = LogManager.getLogger(App23FetchTypeDiv.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        logger.info("Hello!");
        Product product= (Product) em.createQuery(
                "select p from Product p" +
                        "left join feach p.category c" +
                        " where p.id = :id and c.id :categoryId"

        )
                .setParameter("id",1L)
                .setParameter("categoryId", 1L)
                .getSingleResult();
        em.getTransaction().commit();
        em.close();
    }
}
