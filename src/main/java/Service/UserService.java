package Service;

import model.User;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class UserService {

    @PersistenceContext(unitName = "movie-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void add(User user) throws Exception {
        entityManager.persist(user);
        entityManager.createQuery("Create table User if not Exists");

    }


    public void delete(User user) throws Exception {
        entityManager.remove(user);
    }

    public List<User> get() throws Exception {
        Query query = entityManager.createQuery("SELECT m from User as m");
        return query.getResultList();
    }
}
