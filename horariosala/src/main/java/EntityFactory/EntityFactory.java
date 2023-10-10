package EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {
    long id;

    public static EntityManager getEntityFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("horariofaculdade");

        return emf.createEntityManager();
    }

}