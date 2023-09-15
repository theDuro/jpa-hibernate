package pl.nullpointerexception.hibernate.advanceJPQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App20MultiJoin {

    private static Logger logger = LogManager.getLogger(App20MultiJoin.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Category> categoryTypedQuery = em.createQuery(
                "SELECT c FROM Category c " +
                        "LEFT JOIN FETCH c.products p " +
                        "LEFT JOIN FETCH p.reviews", Category.class);

        List<Category> list = categoryTypedQuery.getResultList();
        for (Category category : list) {
            logger.info(category);
        }

        em.getTransaction().commit();
        em.close();
    }
   // poprawną składnię zapytania. Upewnij się, że Twoje klasy encji i relacje między nimi są również poprawnie zmapowane, aby to zapytanie działało poprawnie.






}
