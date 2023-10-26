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

    public static boolean validaSala(int dia, int turno, int sala, EntityManager em) {
        TypedQuery<Aulas> query = em.createQuery(
                "SELECT a FROM Aulas a WHERE a.dia = :dia AND a.turno = :turno AND a.sala = :sala", Aulas.class);
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

    public static boolean validaProfessor(int dia, int turno, int professor, EntityManager em) {
        TypedQuery<Aulas> query = em.createQuery(
                "SELECT a FROM Aulas a WHERE a.dia = :dia AND a.turno = :turno AND a.professor = :professor",
                Aulas.class);
        query.setParameter("dia", dia);
        query.setParameter("turno", turno);
        query.setParameter("professor", professor);

        List<Aulas> aulas = query.getResultList();

        if (aulas.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void cadastroAula(String nome, int dia, int turno, int professor, int sala, EntityManager em) {

        Aulas aulas = new Aulas(nome, professor, sala, turno, dia);

        em.getTransaction().begin();
        em.persist(aulas);
        em.getTransaction().commit();
        System.out.println("Aula criada!");
    }

    public static Long puxarID(int dia, int turno, int sala, EntityManager em){
        TypedQuery<Aulas> query = em.createQuery(
                "SELECT a FROM Aulas a WHERE a.dia = :dia AND a.turno = :turno AND a.sala = :sala", Aulas.class);
        query.setParameter("dia", dia);
        query.setParameter("turno", turno);
        query.setParameter("sala", sala);

        List<Aulas> aulas = query.getResultList();

        if (aulas.isEmpty()) {
            return (long) 0;
        } else {
            Aulas aulaEncontrada = aulas.get(0);
            Long id = aulaEncontrada.getId();
            return id;
        }
    }

    public static void excluirAula(Long id, EntityManager em){
        Aulas a = em.find(Aulas.class, id);

        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        System.out.println("Aula excluida!");
    }
}