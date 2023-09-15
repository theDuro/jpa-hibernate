package pl.nullpointerexception.hibernate.advanceJPQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App19Join {

    private static Logger logger = LogManager.getLogger(App19Join.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Product> productTypedQuery = em.createQuery(
                "select  p from Product p " +
                        "left join fetch p.category c "
                , Product.class);

        List<Product> productList = productTypedQuery.getResultList();

        em.getTransaction().commit();
        em.close();
    }
}
