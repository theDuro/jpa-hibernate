package pl.nullpointerexception.hibernate.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App05OneToMeny {

    private static Logger logger = LogManager.getLogger(App.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Product> productList = em.createQuery("SELECT p FROM Product p").getResultList();

        for(Product product:productList){
            logger.info(product.getName());
            logger.info(product.getReviews());
        }

        em.getTransaction().commit();
        em.close();
    }
}
