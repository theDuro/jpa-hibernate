package pl.nullpointerexception.hibernate.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App13AddOneToMeny {

    private static Logger logger = LogManager.getLogger(App13AddOneToMeny.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Product product =em.find(Product.class,5L);
        Review review = new Review();
        review.setContent("nowa opinia");
        review.setRating(5);
        review.setProduct(product);
        em.persist(review);
        em.getTransaction().commit();
        em.close();
    }
}
