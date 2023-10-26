package EntityFactory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Dominio.Aulas;

public class EntityFactory {
    long id;

    public static EntityManager getEntityFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("horariofaculdade");

        return emf.createEntityManager();
    }

    public static boolean validaAula(int dia, int turno, int sala, EntityManager em){
        TypedQuery<Aulas> query = em.createQuery("SELECT a FROM Aulas a WHERE a.dia = :dia AND a.turno = :turno AND a.sala = :sala", Aulas.class);
        query.setParameter("dia", dia);
        query.setParameter("turno", turno);
        query.setParameter("sala", sala);

        List<Aulas> aulas = query.getResultList();

        if (aulas.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}