package sio.tp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sio.tp2.entities.User;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User, Integer>
{
    List<User> findAll();
    List<User> findByLoginUserAndPwdUser(String LoginUser, String pwdUser);
}
