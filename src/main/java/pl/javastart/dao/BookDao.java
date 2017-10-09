package pl.javastart.dao;

import pl.javastart.model.Book;

public interface BookDao {
    public void save(Book books);
    public Book get(Long id);
}