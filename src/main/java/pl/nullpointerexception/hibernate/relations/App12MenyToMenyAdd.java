package pl.nullpointerexception.hibernate.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Attribute;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App12MenyToMenyAdd {

    private static Logger logger = LogManager.getLogger(App12MenyToMenyAdd.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Attribute attribute =em.find(Attribute.class,1L);
        Product product = em.find(Product.class,5L);
        product.addAtribute(attribute);
        em.getTransaction().commit();
        em.close();
    }
}
