package repository.repositoryList;

public interface Repository<T, ID> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    T findById(ID id);
}
