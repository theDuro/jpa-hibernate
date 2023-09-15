package pl.nullpointerexception.hibernate.advanceJPQL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.ProductInCategoryCounterDto;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App18 {

    private static Logger logger = LogManager.getLogger(App18.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
    Query qery= em.createQuery(
            "SELECT p.category.id,COUNT(p) FROM Product p GROUP BY p.category "
    );
    List<Object[]> list =qery.getResultList();
    List<ProductInCategoryCounterDto> productInCategoryCounterDtoList=list.stream()
            .map(o-> new ProductInCategoryCounterDto((Long) o[0], (Long) o[1]))
            .collect(Collectors.toList());
    for(ProductInCategoryCounterDto prd :productInCategoryCounterDtoList){
        logger.info(prd);
    }


        em.getTransaction().commit();
        em.close();
    }
}
