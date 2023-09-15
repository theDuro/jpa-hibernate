package pl.nullpointerexception.hibernate.relations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.nullpointerexception.hibernate.entity.Product;
import pl.nullpointerexception.hibernate.entity.Review;
import pl.nullpointerexception.hibernate.entity.ReviewDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class App17UpdateOneToMeny {

    private static Logger logger = LogManager.getLogger(App17UpdateOneToMeny.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        reviewDtos.add(new ReviewDto(13L,"Trsesci opini",10));
        reviewDtos.add(new ReviewDto(14L,"Trsesci opini v2",10));
        reviewDtos.add(new ReviewDto(15L,"Trsesci opini v3",10));
        Product product =em.find(Product.class,1L);
        for(Review review: product.getReviews()){

        }
        em.getTransaction().commit();
        em.close();
    }
}
