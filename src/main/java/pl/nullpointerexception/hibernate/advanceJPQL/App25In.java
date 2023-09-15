package pl.nullpointerexception.hibernate.advanceJPQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class App25In {

    private static Logger logger = LogManager.getLogger(App25In.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Order> orderList = em.createQuery(
                "select o from Ordero " +
                        "where o.id in :ids")
                        .setParameter("ids",list)
                                .getResultList();
        em.getTransaction().commit();
        em.close();
    }
}
