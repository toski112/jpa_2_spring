package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceUnit(name = "spring-jpa-pu")
    private EntityManagerFactory emFactory;

    BookDaoImpl() {
    }

    @Override
    public void save(Book books) {
        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(books);
        tx.commit();
        entityManager.close();
    }

    @Override
    public Book get(Long id) {
        EntityManager entityManager = emFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }
}
