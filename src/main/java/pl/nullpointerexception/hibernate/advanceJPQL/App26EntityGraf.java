package pl.nullpointerexception.hibernate.advanceJPQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Order;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class App26EntityGraf {

    private static Logger logger = LogManager.getLogger(App26EntityGraf.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        EntityGraph en = em.getEntityGraph("order-rows");
        Map<String ,Object> map = new HashMap<>();
        map.put("java.persistance.feachgraf",en);
        Order order = em.find(Order.class,1L,map);
        em.getTransaction().commit();
        em.close();
    }
}
