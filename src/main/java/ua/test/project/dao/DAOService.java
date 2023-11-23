package ua.test.project.dao;

import java.util.List;

public interface DAOService<T> {
    List<T> listAll();
    T add(T element);
    void deleteById(long id);
    void update(T element);
    T getById(long id);
}
