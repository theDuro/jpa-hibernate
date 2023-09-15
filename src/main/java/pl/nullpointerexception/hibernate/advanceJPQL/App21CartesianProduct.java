package pl.nullpointerexception.hibernate.advanceJPQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.QueryHints;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App21CartesianProduct {

    private static Logger logger = LogManager.getLogger(App21CartesianProduct.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Product> resultList = em.createQuery(
                        "select distinct p from Product p" +
                                " left join fetch p.attributes",
                        Product.class
                )
                .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
                .getResultList();

        resultList = em.createQuery(
                        "select distinct p from Product p" +
                                " left join fetch p.reviews",
                        Product.class
                )
                .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
                .getResultList();

        logger.info("Size: " + resultList.size());
        for (Product product : resultList) {
            logger.info(product);
            logger.info(product.getAttributes());
            logger.info(product.getReviews());
        }


        em.getTransaction().commit();
        em.close();
    }
}
