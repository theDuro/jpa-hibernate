package pl.nullpointerexception.hibernate.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App15DelteMenyToMeny {

    private static Logger logger = LogManager.getLogger(App15DelteMenyToMeny.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        logger.info("Hello!");
        em.getTransaction().commit();
        em.close();
    }
}
