package pl.nullpointerexception.hibernate.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.App;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App03Update {

    private static Logger logger = LogManager.getLogger(App.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

//        Product product = em.find(Product.class, 1L);
//        product.setName("Nowy Rower 01");


        Product product = new Product();
        product.setId(1L);
        product.setName("Nowy Rower 02");
        Product merged = em.merge(product);
        logger.info(merged);
        em.getTransaction().commit();
        em.close();
    }
}
