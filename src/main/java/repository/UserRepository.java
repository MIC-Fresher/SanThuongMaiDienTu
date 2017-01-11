package repository;

import entity.User;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByemail(String email) throws Exception;

    public List<User> findByUserNameOrEmail(String username, String email) throws Exception;

    @Procedure(name = "deleteRU")
    int deleteRU(@Param("idrole") Integer idrole, @Param("iduser") Integer iduser) throws Exception;

    @Procedure(name = "addRU")
    int addRU(@Param("idrole") Integer idrole, @Param("iduser") Integer iduser) throws Exception;
}
