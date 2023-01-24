package se.me0nly.myJpaOrm1a2.data;

import java.util.Collection;

public interface GenericCRUD <T, ID>{
    T findById(ID id);
    Collection<T> findAll();
    T create(T t);
    T update(T t);
    void delete(ID id);
}
