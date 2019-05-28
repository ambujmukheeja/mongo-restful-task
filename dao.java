import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {
    Optional<T> find(ID id) throws NoSQLException;
    List<T> findAll() throws NoSQLException;
    boolean save(T o) throws NoSQLException;
    boolean update(T o) throws NoSQLException;
    boolean delete(T o) throws NoSQLException;
}
